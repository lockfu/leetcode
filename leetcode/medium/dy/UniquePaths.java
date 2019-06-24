package dy;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
		m--;
		n--;
		if(m<n){
			m = m+n;
			n = m - n;
			m = m - n;
		}
		long res = 1;
		int j = 1;
		for(int i = m+1; i<=m+n; i++, j++){
			res *= i;
			res /= j;
		}
		return (int)res;
	}
	
	public int uniquePathsDp(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
		int[][] grid = new int[m][n];
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(j == 0 || i == 0)
					grid[i][j] = 1;
				else
					grid[i][j] = grid[i][j-1] + grid[i-1][j];
			}
		}
		return grid[m-1][n-1];
	}
}
