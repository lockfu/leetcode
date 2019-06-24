package cn.fxx.lco;

class matrix{
	int row;
	int col;
	public matrix(int row, int col) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.col = col;
	}
}

public class MatrixDy {
	public void bestMatrix(matrix[] A){
		int n = A.length;
		int[][] m = new int[n][n];
		for(int l = 2; l < n; l++){
			for(int i = 1; i<n-l+1; i++){
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++){
					m[i][j] = Math.min(m[i][j], m[i][k] + m[k+1][j] + A[i-1].col * A[k].row + A[j].row);
				}
			}
		}
	}
}
