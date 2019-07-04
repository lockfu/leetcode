package chap06;

import java.util.HashMap;
import java.util.Map;

public class PrintProperty {
	public static void printPro(int n){
		if(n < 1 ) return ;
		dfs(n, 0, 0);
	}
	public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static int count = 0;
	public static void dfs(int n, int step, int cursum){
		if(step == n){
			count++;
			if(map.containsKey(cursum)){
				map.put(cursum, map.get(cursum)+1);
			}else{
				map.put(cursum, 1);
			}
			return;
		}
		for(int i = 1; i<=6; i++){
			cursum += i;
			dfs(n, step+1, cursum);
			cursum-=i;
		}
	}
	
	public static void main(String[] args) {
		printPro(3);
		System.out.println(count);
		System.out.println(map);
	}
}
