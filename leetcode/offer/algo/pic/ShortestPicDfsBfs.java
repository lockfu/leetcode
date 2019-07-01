package algo.pic;

public class ShortestPicDfsBfs {
	private static int mmin = Integer.MAX_VALUE;
	private static int MAXINT = Integer.MAX_VALUE;
	public static void dfs(int[][] A, int step, int dest, int min, boolean[] walked){
		if(min > mmin) return;
		if(step == dest){
			if(min < mmin)
				mmin = min;
			return;
		}
		for(int i = 0; i<A.length; i++){
			if(A[step][i] != MAXINT && !walked[i]){
				walked[i] = true;
				dfs(A, i, dest, min+A[step][i], walked);
				walked[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[][] A = {
				{0,2,MAXINT,MAXINT,10},
				{MAXINT,0,3,MAXINT,7},
				{4,MAXINT,0,4,MAXINT},
				{MAXINT,MAXINT,MAXINT,0,5},
				{MAXINT,MAXINT,3,MAXINT,0}
		};
		boolean[] walked = new boolean[A.length];
		walked[0] = true;
		int min = 0;
		dfs(A, 0, 4, min, walked);
		System.out.println(mmin);
	}
	
}
