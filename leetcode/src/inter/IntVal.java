package inter;

public class IntVal {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 128;
		Integer i2 = 128;  // 堆
		Integer i3 = new Integer(128);  // 内存
		// Integer会自动拆箱为int，所以为true
		System.out.println(i == i2); // true
		System.out.println(i == i3);  // true
		System.out.println(i2==i3);
		System.out.println("**************");
		Integer i5 = 127;// java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
		Integer i6 = 127;
		System.out.println(i5 == i6); // true
		/*
		 * Integer i5 = 128; Integer i6 = 128; System.out.println(i5 ==
		 * i6);//false
		 */
		Integer ii5 = new Integer(127);
		System.out.println(i5 == ii5); // false
		Integer i7 = new Integer(128);
		Integer i8 = new Integer(123);
		System.out.println(i7 == i8); // false
		
		System.out.println("ff" + null);
		
		String abc = new String("abc");
		Long a = 127l;
		Long b = 127l;
		System.out.println(a == b);
	}
}
