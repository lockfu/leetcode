package arrayandstring2;

import org.junit.Test;

public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int[][] res = new int[board.length][];
		for (int i = 0; i < board.length; i++) {
			res[i] = new int[board[i].length];
			for (int j = 0; j < board[i].length; j++) {
				int tmp = compuCell(board, i, j);
				res[i][j] = tmp;
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = res[i][j];
			}
		}
	}
	
	public void gameOfLife1(int[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0)
			return ;
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		for (int i = 0; i < board.length; i++) {
			int liveCount = 0;
			for (int j = 0; j < board[i].length; j++) {
				for(int k = 0; k<8; k++){
					int x = i+dx[k];
					int y = j+dy[k];
					if(x >= 0 && x < board.length && y >= 0 && y < board[i].length && (board[x][y] == 1 || board[x][y] == 1)){
						liveCount++;
					}
						
				}
				if(board[i][j] == 1 && (liveCount < 2 || liveCount > 3))
					board[i][j] = 2;
				else if(board[i][j] == 0 && liveCount == 3)
					board[i][j] = 3;
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] %= 2;
			}
		}
		
	}

	public int compuCell(int[][] board, int i, int j) {

		int liveCount = 0;

		if ((i - 1) >= 0 && (j - 1) >= 0 && board[i - 1][j - 1] == 1)
			liveCount += 1;
		if ((i - 1) >= 0 && board[i - 1][j] == 1)
			liveCount += 1;
		if ((i - 1) >= 0 && (j + 1) < board[i - 1].length
				&& board[i - 1][j + 1] == 1)
			liveCount += 1;
		if ((j - 1) >= 0 && board[i][j - 1] == 1)
			liveCount += 1;
		if ((j + 1) < board[i].length && board[i][j + 1] == 1)
			liveCount += 1;
		if ((i + 1) < board.length && (j - 1) >= 0 && board[i + 1][j - 1] == 1)
			liveCount += 1;
		if ((i + 1) < board.length && board[i + 1][j] == 1)
			liveCount += 1;
		if ((i + 1) < board.length && (j + 1) < board[i+1].length
				&& board[i + 1][j + 1] == 1)
			liveCount += 1;

		if (board[i][j] == 1) {
			if (liveCount == 2 || liveCount == 3)
				return 1;
		} else {
			if (liveCount == 3)
				return 1;
		}
		return 0;
	}

	@Test
	public void test() {
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
