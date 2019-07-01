package algo.search;

import java.util.LinkedList;

public class MiGong {
	private static int min = Integer.MAX_VALUE;
	public static int[][] next = {
		{0,1},
		{1,0},
		{0,-1},
		{-1,0}
	};
	public static void dfs(int[][] A,int curx, int cury, 
			int x, int y, int path, boolean[][] walked){
		if(path > min) return;
		if(curx == x && cury == y){
			if(path < min)
				min = path;
			return;
		}
		
		for(int i = 0; i<4; i++){
			int tx = curx + next[i][0];
			int ty = cury + next[i][1];
			if(tx < 0 || tx >= A.length 
					|| ty < 0 || ty >= A[0].length
					|| walked[tx][ty] || A[tx][ty] == 1)
				continue;
			walked[tx][ty] = true;
			dfs(A, tx, ty, x, y, path+1, walked);
			
		}
	}
	
	public static void bfs(int[][] A, int x, int y){
		LinkedList<NodeMiGong> q = new LinkedList<>();
		boolean[][] walked = new boolean[A.length][A[0].length];
		walked[0][0] = true;
		q.add(new NodeMiGong(0, 0, 0));
		boolean flag = false;
		while(!q.isEmpty()){
			NodeMiGong cur = q.peek();
			for(int i = 0; i<4; i++){
				int tx = cur.x + next[i][0];
				int ty = cur.y + next[i][1];
				if(tx < 0 || tx >= A.length 
						|| ty < 0 || ty >= A[0].length
						|| walked[tx][ty] || A[tx][ty] == 1)
					continue;
				walked[tx][ty] = true;
				q.add(new NodeMiGong(tx, ty, cur.s+1));
				if(tx == x && ty == y){
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
			q.poll();
		}
		System.out.println(" " + q.getLast().s);
	}
	
	public static void main(String[] args) {
		int[][] A = {
				{0,0,1,0},
				{0,0,0,0},
				{0,0,1,0},
				{0,1,0,0},
				{0,0,0,1}
		};
		
//		boolean[][] walked = new boolean[A.length][A[0].length];
//		walked[0][0] = true;
//		dfs(A, 0, 0, 3, 2, 0, walked);
//		System.out.println(min);
		
		bfs(A, 3, 2);
	}
}

class NodeMiGong{
	public int x;
	public int y;
	public int s;
	public NodeMiGong(int x, int y, int s){
		this.x = x;
		this.y = y;
		this.s = s;
	}
}
