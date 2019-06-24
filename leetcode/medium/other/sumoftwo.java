package other;

public class sumoftwo {
	public int getSum(int a, int b) {
		while(b!=0){
			int res = a ^ b;
			b = (a & b) << 1;
			a = res;
		}
		return a;
	}
}
