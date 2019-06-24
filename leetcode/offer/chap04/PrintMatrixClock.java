package chap04;

public class PrintMatrixClock {
	public static void printMatrix(int[][] A){
		if(null == A || A.length <= 0 || A[0].length <= 0) return;
		int rows = A.length, cols = A[0].length;
		int times = rows < cols ? ((rows + 1) / 2) : ((cols + 1) / 2);
		System.out.println("times: " + times);
		int start = 0;
		for(int i = 1; i<= times; i++){
			int collen = cols - 2*(i-1);
			int rowlen = rows - 2*(i-1);
			System.out.println("collen: " + collen);
			System.out.println("rowlen: " + rowlen);
			if(collen == 1 && rowlen == 1)
				System.out.print(A[start][start] + " ");
			else if(collen == 1){
				for(int k = start; k < start+rowlen; k++){
					System.out.print(A[k][start] + " ");
				}
			}else if(rowlen == 1){
				for(int k = start; k < start+collen; k++){
					System.out.print(A[start][k] + " ");
				}
			}else{
				int endx = start + collen-1;
				int endy = start + rowlen-1;
				System.out.println("endx: " + endx);
				System.out.println("endy: " + endy);
				// left --> right
				for(int r = start; r <= endx; r++){
					System.out.print(A[start][r] + " ");
				}
				// up --> down
				for(int r = start+1; r <= endy; r++){
					System.out.print(A[r][endx] + " ");
				}
				// right --> left
				for(int r = endx-1; r >=start; r--){
					System.out.print(A[endy][r] + " ");
				}
				// down --> up
				for(int r = endy-1; r > start; r--){
					System.out.print(A[r][start] + " ");
				}
				start++;
			}
		}
	}
	
	public static void printMatrix2(int[][] A){
		if(null == A || A.length <= 0 || A[0].length <= 0) return;
		int rows = A.length, cols = A[0].length;
		int start = 0;
		while(cols > start*2 && rows > start*2){
			printMatrix(A,cols, rows, start);
			++start;
		}
	}
	
	public static void printMatrix(int[][] A,int cols, int rows, int start){
		int endX = cols - 1 - start;
		int endY = rows -1 - start;
		// left --> right
		for(int r = start; r <= endX; r++){
			System.out.print(A[start][r] + " ");
		}
		if(start < endY) // 至少有两行
			// up --> down
			for(int r = start+1; r <= endY; r++){
				System.out.print(A[r][endX] + " ");
			}
		if(start < endY && start < endX)// 至少两行 两列
			// right --> left
			for(int r = endX-1; r >=start; r--){
				System.out.print(A[endY][r] + " ");
			}
		if(start < endY-1 && start < endX)  // 至少三行两列
			// down --> up
			for(int r = endY-1; r > start; r--){
				System.out.print(A[r][start] + " ");
			}
	}
	
	public static void main(String[] args) {
//		int[][] A = {
//				{1, 2, 3, 4},
//				{5, 6, 7, 8},
//				{9, 10,11,12},
//				{13,14,15,16},
//		};
		
//		int[][] A = {
//				{1, 2, 3, 4},
//		};
//		int[][] A = {
//				{4},
//				{8},
//				{12},
//				{16},
//		};
//		int[][] A = {
//				{1}
//		};
		
		int[][] A = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10,11,12},
				{13,14,15,16},
				{17,18,19,20},
		};
		
		printMatrix2(A);
	}
}
