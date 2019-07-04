package chap06;

public class GetSumNotIf {
	private static int n;
	private static int sum;
	public GetSumNotIf() {
		n++;
		sum += n;
	}
	public static int getSum(){
		return sum;
	}
	public static void reset(){
		n = 0;
		sum = 0;
	}
	public static void main(String[] args) {
		reset();
		GetSumNotIf[] gs = new GetSumNotIf[5];
		
		System.out.println(getSum());
	}
}
