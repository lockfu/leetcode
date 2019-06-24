package math;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FractionToDec {
	public static String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0) return "0";
		StringBuilder res = new StringBuilder();
		res.append((numerator > 0) ^ (denominator > 0) ? "-" : "" );
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		
		res.append(num/den);
		num %= den;
		if(num == 0)
			return res.toString();
		res.append(".");
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(num, res.length());
		while(num != 0){
			num *= 10;
			res.append(num / den);
			num %= den;
			if(map.containsKey(num)){
				int index = map.get(num);
				res.insert(index, "(");
				res.append(")");
				break;
			}else{
				map.put(num, res.length());
			}
		}
		return  res.toString();
    }
	public static void main(String[] args) {
//		String res = fractionToDecimal(5,2);
//		System.out.println(res);
//		AtomicInteger ai = new AtomicInteger();
//		ai.getAndIncrement();
//		Hashtable<String, Integer> tt = new Hashtable<>();
//		tt.put(null, 1);
//		Integer i = tt.get(null);
//		System.out.println(i);
		
		ConcurrentHashMap<String, Integer> tt = new ConcurrentHashMap<>();
		tt.put("1", null);
		Integer i = tt.get("1");
		System.out.println(i);
		
//		HashMap<String, Integer> tm = new HashMap<>();
//		tm.put(null, 1);
//		tm.get(null);
	}
}
