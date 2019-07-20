package chap03;

public class Power {
	public static double power(double base, int exp){
		if(exp == 0) return 1;
		if(exp == 1) return base;
		if(exp < 0){
			exp = -exp;
			base = -base;
		}
		return exp % 2 == 0 ? power(base*base, exp / 2) : base * power(base*base, exp / 2);
	}
	
	public static void main(String[] args) {
		double res  = power(2,4);
		System.out.println(res);
	}
}
