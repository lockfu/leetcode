package treeandGraph;

public class FriendCircleNum {
	 public int findCircleNum(int[][] M) {
	        if(M == null || M.length == 0 || M[0].length == 0)
	            return 0;
	        int res = 0;
	        int n = M.length;
	        boolean[] visited = new boolean[n];
	        for(int i = 0; i<n; i++){
	            if(visited[i]) continue;
	            helper(M,i,visited);
	            res++;
	        }
	        return res;
	    }
	    
	    private void helper(int[][] M, int i, boolean[] visited){
	        if(visited[i]) return ;
	        visited[i] = true;
	        for(int j = 0; j<visited.length; j++){
	            if(i != j && M[i][j] == 1){
	                helper(M, j, visited);
	            }
	        }
	    }
}
