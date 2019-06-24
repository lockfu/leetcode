package cn.dy.bk;

import java.util.ArrayList;
import java.util.List;

public class ZoneProb {
	
	// -------------------------------------
	//    0-1 back problem
	private static final int N = 3;
	private static final int C = 16;
	int[] W = {10, 8, 5};
	int[] V = {5, 4, 1};
	int[] X = {0, 0, 0};
	
	int curweight = 0;
	int curvalue = 0;
	int bestValue = 0;
	int[] bestX = new int[N];
	
	void backtrack(int t){
		
		if(t > N - 1){
			if(curvalue > bestValue){
				bestValue = curvalue;
				for(int i = 0; i<N; i++) bestX[i] = X[i];
			}
		}else{
			for(int i = 0; i<=1; i++){
				if(i == 0)
					backtrack(t+1);
				else{
					if((curweight + W[t]) <= C){
						curweight += W[t];
						curvalue += V[t];
						backtrack(t+1);
						curweight -= W[t];
						curvalue -= V[t];
					}
				}
			}
		}
	}
	
	// ----------------------------------------------------
	//   trival saler
	private final static int CITY = 4;
	private final static int NO_PATH = -1;
	int[][] cityGraph = new int[CITY+1][CITY+1];
	int[] cx = new int[CITY+1];     // 第i步遍历的城市
	int[] isIn = new int[CITY+1];    // 城市i是否已经加入路径
	int bestw;						// 最好路径总权值
	int cw;							// 当前路径总权值
	int[] bextx = new int[CITY+1];   // 最优路径
	void travelBacktrack(int t){
		if(t > CITY){
			for(int i = 1; i<=CITY; i++)
				System.out.print(cx[i] + " ");
			System.out.println();
			if(cw < bestw){
				for(int i = 0; i<=CITY; i++){
					bextx[i] = cx[i];
				}
				bestw = cw;
			}
			return;
		}else{
			for(int i = 1; i<=CITY; i++){
				if(cityGraph[cx[t-1]][i] != NO_PATH && isIn[i] == 0){
					isIn[i] = 1;
					cx[t] = i;
					cw += cityGraph[cx[t-1]][i];
					travelBacktrack(t+1);
					isIn[i] = 0;
					cx[t] = 0;
					cw -= cityGraph[cx[t-1]][i];
				}
			}
		}
	}
	
	
	// ----------------------------------------------------
	//     n queen
	boolean fesible(int[][] board, int r, int c){
		if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
		if(board[r][c] != 0) return false;
		for(int i = 0; i<board.length; i++){
			if(board[r][i] != 0 || board[i][c] != 0) return false;
		}
		for(int i = 1; i<board.length; i++){
			if((r-i) >= 0 && (c-i) >= 0)  // 左上角
				if(board[r-i][c-i] != 0) return false;
			if((r+i) < board.length && (c-i) >= 0)  // 左下角
				if(board[r+i][c-i] != 0) return false;
			if((r-i) >= 0 && (c+i) < board.length)  // 右上角
				if(board[r-i][c+i] != 0) return false;
			if((r+i) < board.length && (c+i) < board.length)  // 右下角
				if(board[r+i][c+i] != 0) return false;
		}
		return true;
	}
	
	
	int way = 0;
	int nqueue = 8;
	// 从第一个queen开始
	void queen(int[][] board, int t){
		if(t > nqueue){
			way++;
			printBoard(board);
		}else{
			for(int i = 0; i<board.length; i++){
				for(int j = 0; j<board.length; j++){
					if(fesible(board, i, j)){
						board[i][j] = 1;
						queen(board, t+1);
						board[i][j] = 0;
					}
				}
			}
		}
	}
	
	void printBoard(int[][] board){
		System.out.println("[");
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board.length; j++){
				if(j == 0)
					System.out.print("[" + board[i][j] + ",");
				else if(j == board.length - 1)
					System.out.print(board[i][j] + "],");
				else 
					System.out.print(board[i][j] + ",");
			}
		}
		System.out.println();
		System.out.println("]");
	}
	void printBoard(char[][] board){
		System.out.println("[");
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board.length; j++){
				if(j == 0)
					System.out.print("[" + board[i][j] + ",");
				else if(j == board.length - 1)
					System.out.print(board[i][j] + "],");
				else 
					System.out.print(board[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println("]");
	}
	
	// ---------------------------------------------------
	//             mis his
	class Path{
		int x;
		int y;
		public Path(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	int numpath = 0;
	List<Path> paths = new ArrayList<>();
	List<Path> shortpath = new ArrayList<>();
	Path outentry = new Path(1,2);
	void mazeTrack(int[][] board, int x, int y){
		Path p = new Path(x,y);
		paths.add(p);
		board[x][y] = 1;
		if(x == outentry.x && y == outentry.y){
			numpath++;
			System.out.println(paths.toString()); // 输出路径
			if(paths.size() < shortpath.size() || shortpath.isEmpty()){
				shortpath.clear();
				for(Path pp : paths){
					shortpath.add(pp);
				}
			}
		}
		if((x-1) >= 0 && board[x-1][y] == 0)  // 上可走
			mazeTrack(board, x-1, y);
		if((x+1) < board.length && board[x+1][y] == 0)  // 下可走
			mazeTrack(board, x+1, y);
		if((y-1) >= 0 && board[x][y-1] == 0)  // 左可走
			mazeTrack(board, x, y-1);
		if((y+1) < board[0].length && board[x][y+1] == 0)  // 右可走
			mazeTrack(board, x, y+1);
		paths.remove(paths.size()-1);
		board[x][y] = 0;
	}
	
	
	// ------------------------------------
	//              valid sudu
	boolean validnum(char[][] board, int r, int c, int num){
		for(int i = 0; i<board.length; i++){
			if((board[r][i]-'0') == num || (board[i][c] - '0') == num) 
				return false;
		}
		int sr = r < 3 ? 0 : r < 6 ? 3 : 6;
		int sc = c < 3 ? 0 : c < 6 ? 3 : 6;
//		System.out.println("r: " + r + " sr: " + sr); 
//		System.out.println("c: " + c + " sc: " + sc);
		for(int i = sr; i < sr+3; i++){
			for(int j = sc; j < sc + 3; j++){
				if((board[i][j]-'0') == num) 
					return false;
			}
		}
		return true;
	}
	
	int needednum(char[][] board){
		int sum = 0;
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board.length; j++){
				if(board[i][j] == '.')
					sum++;
			}
		}
		return sum;
	}
	
	void validsudu(char[][] board, int t, int N){
		if(t > N){
			printBoard(board);
			return;
		}else{
			for(int i = 0; i<board.length; i++){
				for(int j = 0; j<board.length; j++){
					if(board[i][j] == '.'){
						for(int k = 1; k<= 9; k++){
							if(validnum(board, i, j, k)){
								board[i][j] = (char)(k+'0');
								System.out.println("----- t: " + t + " boid: " + board[i][j]);
								validsudu(board, t+1, N);
								board[i][j] = '.';
							}
						}
					}
				}
			}
		}
	}
	
	
	public boolean validsudu2(char[][] board, int t){
		if(t == 81){
			printBoard(board);
			return true;
		} 
		int i = t / 9, j = t % 9;
		if(board[i][j] != '.') return validsudu2(board, t+1);
		else{
			for(char f = '1'; f <= '9'; f++){
				if(validChar(board, i,j,f)){
					board[i][j] = f;
					if(validsudu2(board, t+1)) return true;
					board[i][j] = '.';
				}
			}
			return false;
		}
	}
	
	public boolean validChar(char[][] board, int i, int j, char f){
		for(int k =0; k<board.length; k++){
			int r = i/3*3 + j/3;
			if(board[i][k] == f || board[k][j] == f || board[r/3*3+k/3][r%3*3+k%3] == f) 
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// validsudu
		char[][] board = {
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
		ZoneProb zp = new ZoneProb();
		zp.validsudu2(board, 1);
//		boolean isvalid = zp.validnum(board, 2, 3, 2);
//		System.out.println(isvalid);
//		int neednum = zp.needednum(board);
//		System.out.println(board.length + "  " + board[0].length);
//		System.out.println("neednum: " + neednum);
//		zp.validsudu(board, 1, neednum);
		
//		ZoneProb zp = new ZoneProb();
//		zp.cityGraph[1][1] = NO_PATH;
//		zp.cityGraph[1][2] = 30;
//		zp.cityGraph[1][3] = 6;
//		zp.cityGraph[1][4] = 4;
//		
//		zp.cityGraph[2][1] = 30;
//		zp.cityGraph[2][2] = NO_PATH;
//		zp.cityGraph[2][3] = 5;
//		zp.cityGraph[2][4] = 10;
//		
//		zp.cityGraph[3][1] = 6;
//		zp.cityGraph[3][2] = 5;
//		zp.cityGraph[3][3] = NO_PATH;
//		zp.cityGraph[3][4] = 20;
//		
//		zp.cityGraph[4][1] = 4;
//		zp.cityGraph[4][2] = 10;
//		zp.cityGraph[4][3] = 20;
//		zp.cityGraph[4][4] = NO_PATH;
//		
//		zp.cx[1] = 1;
//		zp.isIn[1] = 1;
//		zp.bestw = Integer.MAX_VALUE;
//		zp.cw =  0;
//		zp.travelBacktrack(2);
//		System.out.println(" bestw: " + zp.bestw);
//		for(int i = 1; i<=CITY; i++){
//			System.out.print(zp.bextx[i] + " " );
//		}
//		System.out.println();
		
	}
}
