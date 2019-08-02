package pattern;

import java.util.Stack;

public class QueueWith2Stack {
	 Stack<Integer> stack1 = new Stack<Integer>();
	 Stack<Integer> stack2 = new Stack<Integer>();
	 public void push(int val){
		 stack1.push(val);
	 }
	 
	 public int pop(){
		 if(stack2.isEmpty()){
			 while(!stack1.isEmpty())
				 stack2.push(stack1.pop());
		 }
		 return stack2.pop();
	 }
}
