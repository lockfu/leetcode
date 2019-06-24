package backtrace;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if(null == board || board.length <= 0 || board[0].length <= 0) return false;
		int m = board.length, n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(search(board, word, 0, i, j, visited)) return true;
			}
		}
		return false;
	}
	public boolean search(char[][] board, String word, int idx, int i, int j, boolean[][] visited){
		if(idx == word.length()) return true;
		int m = board.length, n = board[0].length;
		if(i<0 || j < 0 || i>=m || j>=n || visited[i][j] || board[i][j] != word.charAt(idx)) return false;
		visited[i][j] = true;
		boolean res = search(board, word, idx+1, i-1, j, visited)
				|| search(board, word, idx+1, i+1, j, visited)
				|| search(board, word, idx+1, i, j-1, visited)
				|| search(board, word, idx+1, i, j+1, visited);
		visited[i][j] = false;
		return res;
	}
}
