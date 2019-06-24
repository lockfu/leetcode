package cn.fxx.lco;

public class MaxSubArr {
	public void sub(String x, String y){
		int m = x.length(), n = y.length();
		int[][] c = new int[m][n];
		for(int i = 1; i<m; i++){
			for(int j = 1; j< n; j++){
				if(x.charAt(i) == y.charAt(j)) c[i][j] = c[i-1][j-1] + 1;
				else 
					c[i][j] = Math.max(c[i][j-1], c[i-1][j]);
			}
		}
	}
}
