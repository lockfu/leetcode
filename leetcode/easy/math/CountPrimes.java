package math;

public class CountPrimes {
	public static int countPrimes(int n) {
		int res = 0;
		for(int i = 2; i<n; i++){
			if(isPrimeNum(i)){
				System.out.print(i + " ");
				res++;
			}
		}
		return res;
	}
	private static boolean isPrimeNum(int i){
		if(i == 2 || i == 3)
			return true;
		for(int j = 2; j<i/2+1; j++){
			if(i % j == 0)
				return false;
		}
		return true;
	}
	
	public static int countPrimes1(int n) {
		boolean[] p = new boolean[n];
		int res = 0;
		for(int i = 2; i<n; i++){
			if(!p[i]){
				res++;
				for(int j = 2; i*j < n; j++)
					p[i*j] = true;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int res = countPrimes(5000);
		System.out.println(res);
	}
}
