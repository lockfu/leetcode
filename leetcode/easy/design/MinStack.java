package design;

import java.util.Stack;

public class MinStack {
	   private Stack<Integer> stack;
	    private Stack<Integer> minStack;
	    public MinStack() {
	        // do initialize if necessary
	        stack = new Stack<Integer>();
	        minStack = new Stack<Integer>();
	    }

	    public void push(int number) {
	        // write your code here
	        stack.push(number);
	        if( minStack.isEmpty()){
	            minStack.push(number);
	        }else if( number <= minStack.peek()){
	            minStack.push(number);
	        }
	    }

	    public int pop() {
	        // write your code here
	        int p = stack.pop();
	        if( p == minStack.peek())
	            minStack.pop();
	        return p;
	    }

	    public int min() {
	        // write your code here
	        return minStack.peek();
	    }
}
