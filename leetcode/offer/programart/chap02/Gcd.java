package programart.chap02;

public class Gcd {
	
	// f(x, y) = f(y, x % y)
	public static int gcd_s1(int x, int y){
		return y == 0 ? x : gcd_s1(y, x % y);
	}
	
	// f(x, y) = f(x - y, y)
	public static int gcd_s2(int x, int y){
		if(x < y)
			return gcd_s2(y, x);
		if(y == 0)
			return x;
		else
			return gcd_s2(x-y, y);
	}
	
	// y = k*y1 x = k * x1 ==> f(x, y) = k * f(x1,y1);
	// x = p * x1  y % p != 0 ==> f(x, y) = f(p*x1, y) = f(x1, y);
	// p = 2;
	public static int gcd_s3(int x, int y){
		if(x < y)
			return gcd_s3(y, x);
		if(y == 0)
			return x;
		else{
			if(x % 2 == 0){
				if(y % 2 == 0)
					return (gcd_s3(x>>1, y>>1) << 1);
				else
					return gcd_s3(x >> 1, y);
			}else{
				if(y % 2 == 0)
					return gcd_s3(x, y>>1);
				else
					return gcd_s3(y, x-y);
			}
		}
	}
	
	
	static abstract class Human{}
	static class Man extends Human{}
	static class Woman extends Human{}
	public void sayHello(Human man){
		System.out.println("Hello Human");
	}
	public void sayHello(Man man){
		System.out.println("Hello Man");
	}
	public void sayHello(Woman man){
		System.out.println("Hello Woman");
	}
	
	
	
	
	public static void main(String[] args) {
//		int res = gcd_s1(42, 30);
//		System.out.println(res);
		
		Human man = new Man();
		Human woman = new Woman();
		Gcd gcd = new Gcd();
		gcd.sayHello(man);
		gcd.sayHello(woman);
	}
}
