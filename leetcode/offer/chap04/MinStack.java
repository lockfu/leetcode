package chap04;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> data;
	private Stack<Integer> min;
	public MinStack() {
		this.data = new Stack<>();
		this.min = new Stack<>();
	}
	
	public void push(Integer val){
		data.push(val);
		if(min.isEmpty() || val < min.peek()){
			min.push(val);
		}else{
			min.push(min.peek());
		}
	}
	
	public int pop(){
		if(!data.isEmpty() && !min.isEmpty()){
			min.pop();
			return data.pop();
		}
		return -1;
	}
	
	public int min(){
		if(!min.isEmpty())
			return min.peek();
		return -1;
	}
	
	public static void main(String[] args) {
		MinStack min = new MinStack();
		min.push(3);
		min.push(2);
		System.out.println(min.min());
		min.push(5);
		min.push(6);
		System.out.println(min.min());
		min.push(1);
		min.push(9);
		System.out.println(min.min());
		min.pop();
		min.pop();
		System.out.println(min.min());
	}
}
