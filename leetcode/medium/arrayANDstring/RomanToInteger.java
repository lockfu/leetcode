package arrayANDstring;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        if(s == null || s.length() == 0)
            return 0;
        char[] cs = s.toCharArray();
        int sum = 0;
        int i;
        for(i = 0; i<cs.length;){
            if(i == cs.length-1){
                sum += map.get(cs[cs.length-1]);
                break;
            }
            int pre = map.get(cs[i]);
            int nxt = map.get(cs[i+1]);
            if(pre < nxt){
                sum += (nxt-pre);
                i+=2;
            }else{
                sum += pre;
                i++;
            }
        }
        return sum;
    }
	
	public int romanToInt_y(String s) {
		int total = 0;
		char last = '#';
		for(int i = 0; i<s.length(); i++){
			char c = s.charAt(i);
			switch(c){
				case 'I':
					total += 1;
					break;
				case 'V':
					total += (last == 'I') ? 3 : 5;
					break;
				case 'X':
					total += (last == 'I') ? 8 : 10;
					break;
				case 'L':
					total += (last == 'X') ? 30 : 50;
					break;
				case 'C':
					total += (last == 'X') ? 80 : 100;
					break;
				case 'D':
					total += (last == 'C') ? 300 : 500;
					break;
				case 'M':
					total += (last == 'C') ? 800 : 1000;
					break;
			}
			last = c;
		}
		return total;
	}
}
