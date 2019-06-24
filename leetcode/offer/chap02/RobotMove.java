package chap02;

public class RobotMove {
	public static int movingCount(int thrshold, int rows, int cols){
		if(thrshold < 0 || rows <= 0 || cols <= 0) return 0;
		boolean[][] visited = new boolean[rows][cols];
		int count = movingCountCore(thrshold, rows, cols, 0, 0, visited);
		return count;
	}
	
	public static int movingCountCore(int thrshold, int rows, int cols, int i, int j, boolean[][] visited){
		
		int count = 0;
		if(check(thrshold, rows, cols, i, j, visited)){
			visited[i][j] = true;
			count = 1 + movingCountCore(thrshold, rows, cols, i+1, j, visited)
					+ movingCountCore(thrshold, rows, cols, i-1, j, visited)
					+ movingCountCore(thrshold, rows, cols, i, j+1, visited)
					+ movingCountCore(thrshold, rows, cols, i, j-1, visited);
		}
		return count;
	}
	
	public static boolean check(int thrshold, int rows, int cols, int i, int j,boolean[][] visited){
		if(i<0 || i >= rows || j < 0 || j >= cols || visited[i][j] || (getDigitSum(i) + getDigitSum(j)) > thrshold) return false;
		return true;
	}
	public static int getDigitSum(int i){
		int sum = 0;
		while(i > 0){
			sum += i % 10;
			i /= 10;
		}
		return sum;
	}
}
