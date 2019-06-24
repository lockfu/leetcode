package math;

public class FacLast1Pos {
	public static int last1Pos(int n){
		int ret = 0;
		while(n != 0){
			n >>= 1;
			ret += n;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		int res = last1Pos(5);
		System.out.println(res);
	}
}
