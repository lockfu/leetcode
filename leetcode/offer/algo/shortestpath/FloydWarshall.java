package algo.shortestpath;

public class FloydWarshall {
	public static void shortestpath(int[][] A){
		if(null == A || A.length <= 0 || A[0].length <= 0) return;
		for(int k = 0; k< A.length; k++){
			for(int i =0; i<A.length; i++){
				for(int j = 0; j<A.length; j++){
					if(A[i][j] > (A[i][k] + A[k][j]))
						A[i][j] = A[i][k] + A[k][j];
				}
			}
		}
		
		for(int i =0; i<A.length; i++){
			for(int j = 0; j<A.length; j++){
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
