package beauchap02;

/**
 * 求二进制中1的个数
 * @author DELL
 *
 */
public class CountBit1 {
	
	public static int count1(int n){
		int num = 0;
		while(n!=0){
			num += n & 1;
			n >>= 1;
		}
		return num;
	}
	
	public static int count(int n){
		int num = 0;
		while(n != 0){
			n &= (n-1);
			num++;
		}
		return num;
	}
	
	public static void main(String[] args) {
		int i = 12;
		int res = count(i);
		int res1 = count1(i);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(res + "  " + res1);
	}
}
