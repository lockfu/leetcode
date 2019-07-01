package algo.pic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class PlanBfs {
	public static void bfs(int[][] A, int start, int end){
		LinkedList<NodePlan> q = new LinkedList<>();
		boolean[] walked = new boolean[A.length];
		q.add(new NodePlan(start, 0));
		walked[start] = true;
		boolean flag = false;
		while(!q.isEmpty()){
			NodePlan cur = q.peek();
			for(int i = 0; i<A.length; i++){
				if(A[cur.x][i] != Integer.MAX_VALUE && !walked[i]){
					walked[i] = true;
					q.add(new NodePlan(i, cur.s+1));
				}
				if(q.getLast().x == end){
					flag = true;
					break;
				}
			}
			if(flag)
				break;
			q.poll();
		}
	}
	
	public static void main(String[] args) {
		HashMap<String, String> hmap = new HashMap<>();
		
		ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap<>();
	}
}

class NodePlan{
	public int x;
	public int s;
	public NodePlan(int x, int s){
		this.x = x;
		this.s = s;
	}
}