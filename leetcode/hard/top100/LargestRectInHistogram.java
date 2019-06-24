package top100;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;

public class LargestRectInHistogram {
	public int largestRectangleArea(int[] heights) {
		int len = heights.length;
		Stack<Integer> s = new Stack<>();
		int max = 0;
		for(int i = 0; i<= len; i++){
			int h = (i == len ? 0 : heights[i]);
			if(s.isEmpty() || h >= heights[s.peek()])
				s.push(i);
			else{
				int tp = s.pop();
				max = Math.max(max, heights[tp] * (s.isEmpty() ? i : i-1-s.peek()));
				i--;
			}
		}
		return max;
	}
	public static void main(String[] args) {
//		int[] he = {2,1,2};
//		LargestRectInHistogram ls = new LargestRectInHistogram();
//		int res = ls.largestRectangleArea(he);
//		System.out.println(res);
		
		
		
		try {
			URL url = new URL("https://www.so.com:8080/s?q=URL+authority&src=srp&fr=hao_360so_b&psid=236ea8b4d9845ae507a0bff9ee29a2ca");
			System.out.println(url.getAuthority());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
