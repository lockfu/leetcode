package array;

public class RotateImg {
	public void rotate(int[][] matrix) {
		// if(A == null){
		// 	return ;
		// }
		// int n = A.length ;
		// for(int i = 0; i < n; i++){
		// 	for(int j = 0; j < n - i; j++){
		// 		int tmp = A[i][j];
		// 		A[i][j] = A[n-1-j][n-1-i];
		// 		A[n-1-j][n-1-i] = tmp;
		// 	}
		// }
		// for(int i = 0; i<n/2; i++){
		// 	for(int j = 0; j<n; j++){
		// 		int tmp = A[i][j];
		// 		A[i][j] = A[n-1-i][j];
		// 		A[n-1-i][j] = tmp;
		// 	}
		// }
        if(matrix == null || matrix.length == 1)
			return ;
		rotateImg(matrix,0);
    }
   	private void rotateImg(int[][] A, int c){ // c代表递归处理的圈数
		int count = A.length - c*2;
		if(count == 1 || count == 0) // 
			return ;
		if(count == 2){
			int temp = A[c][c];
			A[c][c] = A[c+1][c];
			A[c+1][c] = A[c+1][c+1];
			A[c+1][c+1] = A[c][c+1];
			A[c][c+1] = temp;
			return ;
		}
		int len = A.length;
		int i = c;
		int end = len - c - 1; // end表示当前循环所能表示的数组的最后一位
		for(int k = 0; k<count-1; k++){ // count表示循环的次数 
			int temp = A[i][i+k];
			A[i][i+k] = A[end-k][i];
			A[end-k][i] = A[end][end-k];
			A[end][end-k] = A[i+k][end];
			A[i+k][end] = temp;
		}
        rotateImg(A,c+1);
	}
 
}
