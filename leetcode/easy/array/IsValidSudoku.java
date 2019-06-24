package array;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<Character> row = new HashSet<>();
		Set<Character> col = new HashSet<>();
		for(int i = 0; i<board.length; i++){
			row.clear();
			col.clear();
			for(int j = 0; j<board.length; j++){
				if(i%3 == 0 && j%3 == 0)
					if(!isBlock(board,i,j)) return false;
				char r = board[i][j]; // row
				char c = board[j][i]; // col
				
				if(r != '.' && !row.add(r))	return false;
				if(c != '.' && !col.add(c))	return false;
			}
			System.out.println("row: " + row.toString());
			System.out.println("col: " + col.toString());
		}
		return true;
	}
	private boolean isBlock(char[][] board, int r, int c){
		Set<Character> set = new HashSet<>();
		for(int i = r ; i< r + 3; i++){
			for(int j = c ; j< c + 3; j++){
				System.out.println("is: " + set.toString());
				if(board[i][j] != '.' && !set.add(board[i][j])) return false;
			}
		}
		System.out.println("end is ");
		return true;
	}
	
	
	public boolean isValidSudoku1(char[][] board) {
		for(int i = 0; i<9; i++){
			boolean[] used = new boolean[10];
			for(int j = 0; j<9; j++){
				if(board[i][j] == '.') continue;
				if(used[board[i][j] - '0']) return false;
				used[board[i][j] - '0'] = true;
			}
		}
		for(int i = 0; i<9; i++){
			boolean[] used = new boolean[10];
			for(int j = 0; j<9; j++){
				if(board[j][i] == '.') continue;
				if(used[board[j][i] - '0']) return false;
				used[board[j][i] - '0'] = true;
			}
		}
		
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				int row = i*3;
				int col = j*3;
				boolean[] used = new boolean[10];
				for(int m = row; m<row+3; m++){
					for(int n = col; n<col+3; n++){
						if(board[m][n] == '.') continue;
						if(used[board[m][n] - '0']) return false;
						used[board[m][n] - '0'] = true;
					}
				}
			}
		}
		return true;
	}
	
	public boolean isValidSudoku2(char[][] board) {
		if(null == board || board.length != 9 || board[0].length != 9)
			return false;
		int len = board.length;
		int SIZE = len * len;
		boolean[] rows = new boolean[SIZE];
		boolean[] cols = new boolean[SIZE];
		boolean[] blocks = new boolean[SIZE];
		for(int i = 0; i<len; i++){
			for(int j = 0; j<len; j++){
				char c = board[i][j];
				if(c == '.') continue;
				int value = (c-'1');
				int indexRows = len*i + value;
				if(rows[indexRows]) return false;
				else rows[indexRows] = true;
				
				int indexCols = len*j + value;
				if(cols[indexCols]) return false;
				else cols[indexCols] = true;
				
				int indexBlock = ((i/3)*3 + (j/3)) * len + value;
				if(blocks[indexBlock]) return false;
				else blocks[indexBlock] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] A = {
		              {'5','3','.','.','7','.','.','.','.'},
		              {'6','.','.','1','9','5','.','.','.'},
		              {'.','9','8','.','.','.','.','6','.'},
		              {'8','.','.','.','6','.','.','.','3'},
		              {'4','.','.','8','.','3','.','.','1'},
		              {'7','.','.','.','2','.','.','.','6'},
		              {'.','6','.','.','.','.','2','8','.'},
		              {'.','.','.','4','1','9','.','.','5'},
		              {'.','.','.','.','8','.','.','7','9'}
		};        
		IsValidSudoku s  = new IsValidSudoku();
		boolean is = s.isValidSudoku1(A);
		System.out.println(is);
	}
}
