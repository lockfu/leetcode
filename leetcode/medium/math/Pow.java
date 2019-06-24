package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Pow {
	public double myPow(double x, int n) {
		if(n == 0)
			return 1;
		if(n<0){
			n=-n;
			x = 1/x;
		}
		return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
	}
	
	
	public double myPow1(double x, int n) {
        return pow(x,(long)n);
    }
    
    private double pow(double x, long n) {
        if(n==0) return 1;
        if(n < 0) {
            n *= -1;
            x = 1/x;
        }
        return n%2==0 ? pow(x*x, n/2L) : x*pow(x*x, n/2L);
    }
	
	public static void main(String[] args) {
		double x = 1;
		double y = 4;
		double res = 2.1*2.1*2.1;
		System.out.println(res);
		
		
//		new ArrayList<>(Arrays.asList(1,2,3,4,5));
	}
}
