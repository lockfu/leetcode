package chap04;

import java.util.Stack;

public class MinStack2 {
	public Stack<Integer> st = new Stack<>();
	private int min = Integer.MAX_VALUE;
	
	public void push(int x){
		if(x <= min){
			st.push(min);
			min = x;
		}
		st.push(x);
	}
	
	public void pop(){
		if(st.pop() == min) min = st.pop();
	}
	
	public int top(){
		return st.peek();
	}
	
	public int getMin(){
		return min;
	}
}
