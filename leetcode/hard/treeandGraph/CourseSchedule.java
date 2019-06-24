package treeandGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList[] graph = new ArrayList[numCourses];
		int[] degree = new int[numCourses];
		Queue queue = new LinkedList<>();
		int count = 0;
		for(int i = 0; i<numCourses; i++){
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i<prerequisites.length; i++){
			degree[prerequisites[i][1]]++;
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		for(int i = 0; i<degree.length; i++){
			if(degree[i] == 0){
				queue.add(i);
				count++;
			}
		}
		while(queue.size()!=0){
			int course = (int)queue.poll();
			for(int i = 0; i<graph[course].size(); i++){
				int pointer = (int)graph[course].get(i);
				degree[pointer]--;
				if(degree[pointer] == 0){
					queue.add(pointer);
					count++;
				}
			}
		}
		return  count == numCourses ? true : false;
	}
	
	
	public int[] canFinish2(int numCourses, int[][] prerequisites) {
		ArrayList[] graph = new ArrayList[numCourses];
		int[] degree = new int[numCourses];
		Queue queue = new LinkedList<>();
		int[] res = new int[numCourses];
		
		int count = 0;
		for(int i = 0; i<numCourses; i++){
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i<prerequisites.length; i++){
			degree[prerequisites[i][1]]++;
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		for(int i = 0; i<degree.length; i++){
			if(degree[i] == 0){
				queue.add(i);
				count++;
			}
		}
		int c = 0;
		while(queue.size()!=0){
			int course = (int)queue.poll();
			res[c++] = course;
			for(int i = 0; i<graph[course].size(); i++){
				int pointer = (int)graph[course].get(i);
				degree[pointer]--;
				if(degree[pointer] == 0){
					queue.add(pointer);
					count++;
				}
			}
		}
		if(c != numCourses){
			return new int[0];
		}
		int[] rr = new int[res.length];
		int cc = 0;
		for(int i = res.length-1; i>=0; i--){
			rr[cc++] = res[i];
		}
		return rr;
	}
	
	public boolean canFinish1(int numCourses, int[][] prerequisites) {
		ArrayList[] graph = new ArrayList[numCourses];
		for(int i = 0; i<numCourses; i++){
			graph[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[numCourses];
		for(int i = 0; i<prerequisites.length; i++){
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}
		for(int i = 0; i<numCourses; i++){
			if(!dfs(graph, visited, i))
				return false;
		}
		return true;
	}
	private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
		if(visited[course])
			return false;
		else
			visited[course] = true;
		for(int i = 0; i<graph[course].size(); i++){
			if(!dfs(graph, visited, (int)graph[course].get(i)))
				return false;
		}
		visited[course] = false;
		return true;
	}
}
