package cn.dy.bk;

public class ZeroOneProblem {
	private int currentweight;
	private int currentvalue;
	private int bestValue;
	private final static int N = 3;
	private final static int C = 16;
	public void zeroOne(int[] w, int[] v, int backweight){
		zeroOne(w, v, 0);
	}
	public void solve(int[] w, int[] v, int t){
		if(t > N-1){
			if(currentvalue > bestValue){
				bestValue = currentvalue;
				return;
			}
		}else{
			for(int i = 0; i<=1; i++){
				if(i == 0)
					solve(w,v, t+1);
				else{
					if((currentweight + w[t]) <= C){
						currentweight += w[t];
						currentvalue += v[t];
						solve(w,v,t+1);
						currentweight -= w[t];
						currentvalue -= v[t];
					}
				}
			}
		}
	}
}
