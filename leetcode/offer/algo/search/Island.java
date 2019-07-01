package algo.search;

import java.util.LinkedList;

public class Island {
	public static int[][] next = {
		{0,1},
		{1,0},
		{0,-1},
		{-1,0}
	};
	public static void bfs(int[][] A, int x, int y){
		LinkedList<NodeIsland> q = new LinkedList<>();
		boolean[][] walked = new boolean[A.length][A[0].length];
		q.add(new NodeIsland(x, y));
		walked[x][y] = true;
		int sum = 1;
		while(!q.isEmpty()){
			NodeIsland cur = q.peek();
			for(int i = 0; i<4; i++){
				int tx = cur.x + next[i][0];
				int ty = cur.y + next[i][1];
				if(tx < 0 || tx >= A.length 
						|| ty < 0 || ty >= A[0].length
						|| walked[tx][ty] || A[tx][ty] == 0)
					continue;
				walked[tx][ty] = true;
				q.add(new NodeIsland(tx, ty));
				sum++;
			}
			q.poll();
		}
		System.out.println(sum);
	}
	private static int sum = 1;
	public static void dfs(int[][] A, int x, int y, boolean[][] walked){
		for(int i = 0; i<4; i++){
			int tx = x + next[i][0];
			int ty = y + next[i][1];
			if(tx < 0 || tx >= A.length 
					|| ty < 0 || ty >= A[0].length
					|| walked[tx][ty] || A[tx][ty] == 0)
				continue;
			walked[tx][ty] = true;
			sum++;
			dfs(A, tx, ty, walked);
		}
	}
	
	public static void dfs2(int[][] A, int x, int y, int color, boolean[][] walked){
		for(int i = 0; i<4; i++){
			int tx = x + next[i][0];
			int ty = y + next[i][1];
			if(tx < 0 || tx >= A.length 
					|| ty < 0 || ty >= A[0].length
					|| walked[tx][ty] || A[tx][ty] == 0)
				continue;
			A[tx][ty] = color;
			walked[tx][ty] = true;
			sum++;
			dfs(A, tx, ty, walked);
		}
	}
	
	public static void main(String[] args) {
		int[][] A = {
				{1,2,1,0,0,0,0,0,2,3},
				{3,0,2,0,1,2,1,0,1,2},
				{4,0,1,0,1,2,3,2,0,1},
				{3,2,0,0,0,1,2,4,0,0},
				{0,0,0,0,0,0,1,5,3,0},
				{0,1,2,1,0,1,5,4,3,0},
				{0,1,2,3,1,3,6,2,1,0},
				{0,0,3,4,8,9,7,5,0,0},
				{0,0,0,3,7,8,6,0,1,2},
				{0,0,0,0,0,0,0,0,1,0}
		};
		bfs(A, 5, 7);
		System.out.println("--------");
		boolean[][] walked = new boolean[A.length][A[0].length];
		walked[5][7] = true;
		A[5][7] = -1;
		dfs(A, 5, 7, walked);
		System.out.println(sum);
	}
}


class NodeIsland{
	public int x;
	public int y;
	public NodeIsland(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
