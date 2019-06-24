package chap02;

public class MatrixPath {
	public static boolean find(char[][] A, String str){
		if(null == A || A.length <= 0 || str == null) return false;
		int m = A.length, n = A[0].length;
		boolean[][] visited = new boolean[m][n];
		int len = 0;
		for(int i = 0; i< m; i++){
			for(int j = 0; j<n; j++){
				if(hasPath(A, str, visited, i, j, len))
					return true;
			}
		}
		return false;
	}
	
	public static boolean hasPath(char[][] A, String str, boolean[][] visited, int i, int j, int len){
		if(len == str.length()) return true;
		if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || visited[i][j]) return false;
		boolean res = false;
		if(A[i][j] == str.charAt(len)){
			len++;
			visited[i][j] = true;
			res = hasPath(A, str, visited, i+1, j, len) 
				|| hasPath(A, str, visited, i-1, j, len)
				|| hasPath(A, str, visited, i, j+1, len)
				|| hasPath(A, str, visited, i, j-1, len);
			if(!res){
				len--;
				visited[i][j] = false;
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		char[][] A = {
				{'a','b','t','g'},
				{'c','f','c','s'},
				{'j','d','e','h'}
		};
		boolean res = find(A, "bfce");
		System.out.println(res);
	}
	
}
