package beauchap02;

/**
 * ��׳�N��ĩβ��0�ĸ���
 * ��һ���׳˶����Ʊ�ʾ�����λ1��λ��
 * @author DELL
 *
 */
public class FacFive {
	
	public static int facFive(int N){
		int ret = 0;
		while(N != 0){
			ret += N/5;
			N/=5;
		}
		return ret;
	}
	
	public static int facTwo(int N){
		int ret = 0;
		while(N != 0){
			N >>= 1;
			ret += N;
		}
		return ret+1;
	}
	
	public static int fac(int N){
		int sum =1;
		while(N > 1){
			sum *= N;
			N--;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int N = 4;
//		int res = facFive(N);
//		System.out.println(res);
		int sum = fac(N);
		System.out.println("sum: " + sum);
		System.out.println(Integer.toBinaryString(sum));
		int res1 = facTwo(N);
		System.out.println(res1);
	}
}
