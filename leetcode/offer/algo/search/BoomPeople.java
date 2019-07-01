package algo.search;

import java.util.LinkedList;

public class BoomPeople {
	public static int getSum(char[][] A, int i, int j){
		int sum = 0, x, y;
		x = i;
		y = j;
		while(A[x][y] != '#'){
			if(A[x][y] == 'G')
				sum++;
			x--;
		}
		
		x = i;
		y = j;
		while(A[x][y] != '#'){
			if(A[x][y] == 'G')
				sum++;
			x++;
		}
		
		x = i;
		y = j;
		while(A[x][y] != '#'){
			if(A[x][y] == 'G')
				sum++;
			y--;
		}
		
		x = i;
		y = j;
		while(A[x][y] != '#'){
			if(A[x][y] == 'G')
				sum++;
			y++;
		}
		return sum;
	}
	
	public static int[][] next = {
		{0,1},
		{1,0},
		{0,-1},
		{-1,0}
	};
	
	public static void bfs(char[][] A, int x, int y){
		LinkedList<NodeBoom> q = new LinkedList<>();
		boolean[][] walked = new boolean[A.length][A[0].length];
		walked[x][y] = true;
		q.add(new NodeBoom(x, y));
		int mx = x, my = y, max = getSum(A, x, y);
		while(!q.isEmpty()){
			NodeBoom cur = q.peek();
			for(int i = 0; i<4; i++){
				int tx = cur.x + next[i][0];
				int ty = cur.y + next[i][1];
				if(tx < 0 || tx >= A.length 
						|| ty < 0 || ty >= A[0].length
						|| walked[tx][ty] || A[tx][ty] == '.')
					continue;
				walked[tx][ty] = true;
				q.add(new NodeBoom(tx, ty));
				int scum = getSum(A, tx, ty);
				if(scum > max){
					mx = tx;
					my = ty;
					max = scum;
				}
			}
			q.poll();
		}
	}
	
	private static int max = Integer.MIN_VALUE;
	private static int mx = 0;
	private static int my = 0;
	public static void dfs(char[][] A, int x, int y, boolean[][] walked){
		int sum = getSum(A, x, y);
		if(sum > max){
			max = sum;
			mx = x;
			my = y;
		}
		for(int i = 0; i<4; i++){
			int tx = x + next[i][0];
			int ty = y + next[i][1];
			if(tx < 0 || tx >= A.length 
					|| ty < 0 || ty >= A[0].length
					|| walked[tx][ty] || A[tx][ty] == '.')
				continue;
			walked[tx][ty] = true;
			dfs(A, tx, ty, walked);
		}
	}
	
}


class NodeBoom{
	public int x;
	public int y;
	public NodeBoom(int x, int y){
		this.x = x;
		this.y = y;
	}
}