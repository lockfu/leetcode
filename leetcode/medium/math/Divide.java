package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class Divide {
	public static int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) 
            sign = -1;
        long divd = (long)dividend;
        divd = divd < 0 ? -divd : divd;
        divisor = divisor < 0 ? - divisor : divisor;
        if(divisor == 1){
        	divd = sign*divd;
        	if(divd > Integer.MAX_VALUE)
        		return Integer.MAX_VALUE;
        	else if(divd < Integer.MIN_VALUE)
        		return Integer.MIN_VALUE;
        	else
        		return (int)divd;
        }
        System.out.println(divd + " " + divisor);
        long count = 0;
        long sum = 0;
        while(sum <= divd){
            sum += divisor;
            count++;
        }
        return (int) (sign*(count-1));
    }
	
	public static int divide1(int dividend, int divisor) {
		if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
		if(dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE;
		boolean sign = ((dividend < 0) ^ (divisor < 0));
		long m = Math.abs((long)dividend), n = Math.abs((long)divisor), res = 0;
		while(m >= n){
			long t = n, p = 1;
			while(m>=(t<<1)){
				t <<= 1;
				p<<=1;
			}
			res += p;
			m -= t;
		}
		return sign ? (int)-res : (int)res;
	}
	
	public static void main(String[] args) {
		int res = divide1(10,3);
		System.out.println(res);
		List<Integer> list = new ArrayList<>();
		list.add(null);
		list.add(null);
		Set<Integer> set = new HashSet<>();
		set.add(null);
		set.add(null);
		
		System.out.println("list: " + list.size() + " set: " + set.size());
	}
}
