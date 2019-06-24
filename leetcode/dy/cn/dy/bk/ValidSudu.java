package cn.dy.bk;

public class ValidSudu {
	public void validsudu(char[][] board){
		if(null == board || board.length < 9) return;
		solve(board, 0);
	}
	public boolean solve(char[][] board, int t){
		if(t == 81) return true;
		int i = t / 9, j = t % 9;
		if(board[i][j] != '.') return solve(board, t+1);
		else{
			for(char f = '1'; f <= '9'; f++){
				if(validFill(board, i, j, f)){
					board[i][j] = f;
					if(solve(board,t+1)) return true;
					board[i][j] = '.';
				}
			}
			return false;
		}
	}
	public boolean validFill(char[][] board, int i, int j, char f){
		for(int k = 0; k<board.length; k++){
			int r = i/3*3 + j/3;
			if(board[i][k] == f || board[k][j] == f || board[r/3*3+k/3][r%3*3+k%3] == f) 
				return false;
		}
		return true;
	}
	
	// ------------------------------------------------------
	public static final int LEN = 9;
	public void validsudu2(char[][] board){
		if(null == board || board.length < 9) return;
		boolean[][] cr = new boolean[LEN][LEN];
		boolean[][] cl = new boolean[LEN][LEN];
		boolean[][] ce = new boolean[LEN][LEN];
		for(int r = 0; r < LEN; r++){
			for(int c = 0; c<LEN; c++){
				if(board[r][c] != '.'){
					int num = board[r][c] - '1';
					int cell = r / 3 * 3 + c / 3;
					cr[r][num] = cr[c][num] = cr[cell][num] = true;
				}
			}
		}
		solve2(board,cr,cl,ce,0,0);
	}
	
	public boolean solve2(char[][] board, boolean[][] cr, boolean[][] cl, boolean[][] ce, int r, int c){
		if(c >= 9){
			r++;
			c = 0;
		}
		if(r >= 9)
			return true;
		if(board[r][c] != '.') return solve2(board, cr,cl,ce,r,c+1);
		else{
			int cell = r / 3 * 3 + c / 3;
			for(int num = 0; num < 9; num++){
				if(!cr[r][num] && !cl[c][num] && !ce[cell][num]){
					board[r][c] = (char)('1'+num);
					cr[r][num] = cl[c][num] = ce[cell][num];
					if(solve2(board, cr,cl,ce,r,c+1)) return true;
					board[r][c] = '.';
					cr[r][num] = cl[c][num] = ce[cell][num] = false;
				}
			}
			return false;
		}
	}
}
