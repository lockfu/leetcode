package chap04;

import java.util.Stack;

public class InOutStack {
	public static boolean isPopOrder(int[] in, int[] out){
		if(in == null || out == null) return false;
		if(in.length != out.length) return false;
		Stack<Integer> st = new Stack<>();
		int len = in.length;
		for(int i = 0, j = 0; i<len && j < len; i++){
			st.push(in[i]);
			while(!st.isEmpty() && j < len && st.peek() == out[j]){
				st.pop();
				j++;
			}
		}
		return st.isEmpty();
	}
	
	public static void main(String[] args) {
		int[] in = {1,2,3,4,5};
//		int[] out = {4,5,3,2,1};
		int[] out = {4,3,5,1,2};
		boolean res = isPopOrder(in, out);
		System.out.println(res);
	}
}
