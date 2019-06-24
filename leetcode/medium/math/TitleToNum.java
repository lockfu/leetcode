package math;

import java.util.HashMap;
import java.util.Map;

public class TitleToNum {
	private static Map<String, Integer> map = new HashMap<>();
	static {
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		map.put("F", 6);
		map.put("G", 7);
		map.put("H", 8);
		map.put("I", 9);
		map.put("J", 10);
		map.put("K", 11);
		map.put("L", 12);
		map.put("M", 13);
		map.put("N", 14);
		map.put("O", 15);
		map.put("P", 16);
		map.put("Q", 17);
		map.put("R", 18);
		map.put("S", 19);
		map.put("T", 20);
		map.put("U", 21);
		map.put("V", 22);
		map.put("W", 23);
		map.put("X", 24);
		map.put("Y", 25);
		map.put("Z", 26);
	}

	public static int titleToNumber(String s) {
		int len = s.length();
		int res = 0;
		int tmp = 1;
		for(int i = 0; i<len; i++){
//			String cur = s.charAt(len-i-1)+ "";
			int curint = 1 + (int)s.charAt(len-i-1) - (int)'A'; //map.get(cur);
//			System.out.println("cur: " + cur + " curint: " + curint);
			res = res + curint * tmp;
			tmp = (tmp == 1 ? 26 : tmp*26); 
		}
		return res;
	}
	
	public static void main(String[] args) {
		int res = titleToNumber("AJHX");
		System.out.println(res);
	}
}
