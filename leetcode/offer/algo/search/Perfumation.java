package algo.search;

import java.util.ArrayList;
import java.util.List;

public class Perfumation {
	
	public static List<String> perfumation(String str){
		List<String> res = new ArrayList<>();
		if(str == null || str.length() <= 0) return res;
		boolean[] walked = new boolean[str.length()];
//		dfs(str.toCharArray(), 0, walked, res);
		dfs2(str.toCharArray(), 0 ,res);
		return res;
	}
	
	public static void dfs2(char[] A, int step, List<String> res){
		if(step == A.length){
			res.add(new String(A));
			return;
		}
		
		for(int i = step; i<A.length; i++){
			char temp = A[step];
			A[step] = A[i];
			A[i] = temp;
			
			dfs2(A, step+1, res);
			
			temp = A[step];
			A[step] = A[i];
			A[i] = temp;
		}
	}
	
	public static void dfs(char[] A, int step, boolean[] walked, List<String> res){
		if(step == A.length){
			res.add(new String(A));
			return;
		}
		for(int i = 0; i<A.length; i++){
			if(!walked[i]){
				char temp = A[step];
				A[step] = A[i];
				A[i] = temp;
				walked[i] = true;
				
				dfs(A, step+1, walked, res);
				
				temp = A[step];
				A[step] = A[i];
				A[i] = temp;
				walked[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "abc";
		List<String> res = perfumation(str);
		System.out.println(res);
	}
}
