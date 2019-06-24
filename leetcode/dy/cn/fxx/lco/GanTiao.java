package cn.fxx.lco;

public class GanTiao {
	public static int splitG(int[] p, int n){
		if(n == 0)
			return 0;
		int q = Integer.MIN_VALUE;
		for(int i = 1; i<=n; i++){
			q = Math.max(q, p[i] + splitG(p, n-i));
		}
		return q;
	}
	public static int splitUpDown(int[] p, int n, int[] s){
		if(s[n] >= 0)
			return s[n];
		int q = 0;
		if(n != 0){
			q = Integer.MIN_VALUE;
			for(int i = 1; i<=n; i++){
				q = Math.max(q, p[i] + splitUpDown(p, n-i,s));
			}
		}
		s[n] = q;
		return q;
	}
	
	public static int splitDownUp(int[] p, int n){
		int[] r = new int[n+1];
		r[0] = 0;
		for(int j = 1; j<=n; j++){
			int q = Integer.MIN_VALUE;
			for(int i = 1; i<=j; i++){
				q = Math.max(q, p[i] + r[j-i]);
			}
			r[j] = q;
		}
		return r[n];
	}
	
	public static int splitDownUpRm(int[] p, int n){
		int[] r = new int[n+1];
		int[] s = new int[n+1];
		r[0] = 0;
		for(int j = 1; j<=n; j++){
			int q = Integer.MIN_VALUE;
			for(int i = 1; i<=j; i++){
				if(q < p[i] + r[j-i]){
					q =  p[i] + r[j-i];
					s[j] = i;
				}
			}
			r[j] = q;
		}
		return r[n];
	}
	
	public static void main(String[] args) {
		int[] p = {0,1,5,8,9,10,17,17,20,24,30};
		int max = splitG(p, 10);
		System.out.println(max);
	}
}
