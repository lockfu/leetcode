package beauchap02;

/**
 * 一个正整数N 从 1到N中的1的个数
 * @author DELL
 *
 */

public class Bit1Num {

	public static int numOf1(int N){
		int res = 0;
		for(int i = 1; i<=N; i++){
			res += count1Num(i);
		}
		return res;
	}
	
	public static int count1Num(int n){
		int num = 0;
		while(n != 0){
			num += (n % 10 == 1) ? 1 : 0;
			n /= 10;
		}
		return num;
	}
	
	
	// --------------------------------
	public static int numOf1_2(int N){
		int res = 0, fac = 1, lownum = 0, curnum = 0, hinum = 0;
		while((N / fac) != 0){
			lownum = N - (N / fac) * fac;
			curnum = (N / fac) % 10;
			hinum = N / (fac * 10);
			switch (curnum) {
				case 0:
					res += hinum * fac;
					break;
				case 1:
					res += hinum * fac + lownum + 1;
					break;
				default:
					res += (hinum + 1) * fac;
					break;
			}
			fac *= 10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int N = 39;
		int res = numOf1_2(N);
		int res1 = numOf1(N);
		System.out.println(res + " " + res1);
	}
}
