package top100;

import java.util.PriorityQueue;

public class KthSmallest {
	public int kthSmallest(int[][] matrix, int k) {
		int n =  matrix.length;
		PriorityQueue<Tuple> pq = new PriorityQueue<>();
		for(int  j = 0; j<=n-1; j++) pq.offer(new Tuple(0,j, matrix[0][j]));
		for(int i = 0; i<k-1; i++){
			Tuple t = pq.poll();
			if(t.x == n-1) continue;
			pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
		}
		return pq.poll().val;
	}
	
	class Tuple implements Comparable<Tuple>{
		int x, y, val;
		public Tuple(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(Tuple o) {
			String s = "";
			return this.val - o.val;
		}
	}
	
	
	
	public int kthSmallest_binary(int[][] matrix, int k) {
		int n =  matrix.length;
		int lo = matrix[0][0], hi = matrix[n-1][n-1];
		while(lo < hi){
			int mid = lo + (hi-lo)/2;
			int count = 0, j = matrix[0].length-1;
			for(int i = 0; i<n; i++){
				while(j >= 0 && matrix[i][j] > mid) j--;
				count += (j+1);
			}
			if(count < k) lo = mid + 1;
			else hi = mid;
		}
		return lo;
	}
	
	public int kthSmallest_binary2(int[][] matrix, int k) {
		int rows = matrix.length, cols = matrix[0].length;
		int lo = matrix[0][0], hi = matrix[rows-1][cols-1];
		while(lo <= hi){
			int mid = lo + (hi-lo)/2;
			int count = 0, maxNum = lo;
			for(int r = 0, c = cols - 1; r < rows; r++){
				while(c >= 0 && matrix[r][c] > mid) c--;
				if(c >= 0){
					count += (c+1);
					maxNum = Math.max(maxNum, matrix[r][c]);
				}
			}
			if(count == k) return maxNum;
			else if(count < k) lo = mid+1;
			else hi = mid -1;
		}
		return lo;
	}
	
	
}
