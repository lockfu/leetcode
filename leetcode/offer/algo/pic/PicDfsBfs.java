package algo.pic;

import java.util.LinkedList;

public class PicDfsBfs {
	public static final int MAXINT = Integer.MAX_VALUE;
	
	public static void dfs(int[][] A, int step, int sum, boolean[] walked){
		System.out.print(step);
		sum++;
		if(sum == A.length) return;
		for(int i = 0; i<A.length; i++){
			if(A[step][i] == 1 && !walked[i]){
				walked[i] = true;
				dfs(A,i,sum,walked);
			}
		}
	}
	
	public static void bfs(int[][] A){
		LinkedList<Integer> q = new LinkedList<>();
		q.add(0);
		boolean[] walked = new boolean[A.length];
		for(int i = 0; i<walked.length; i++){
			walked[i] = false;
		}
		walked[0] = true;
		System.out.print(0 + " ");
		while(!q.isEmpty()){
			int cur = q.peek();
			for(int i = 0; i<A.length; i++){
				if(A[cur][i] == 1 && !walked[i]){
					System.out.print(i + " ");
					q.add(i);
					walked[i] = true;
				}
			}
			q.poll();
		}
	}
	
	public static void main(String[] args) {
		
		int[][] A = {
				{0,1,1,MAXINT,1},
				{1,0,MAXINT,1,MAXINT},
				{1,MAXINT,0,MAXINT,1},
				{MAXINT,1,MAXINT,0,MAXINT},
				{1,MAXINT,1,MAXINT,0}
		};
		boolean[] walked = new boolean[A.length];
		walked[0] = true;
		dfs(A, 0, 1, walked);
		System.out.println();
		bfs(A);
	}
}
