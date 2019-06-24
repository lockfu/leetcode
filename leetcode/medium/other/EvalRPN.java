package other;

import java.util.Stack;

public class EvalRPN {
	public int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length <= 0)
			return -1;
		Stack<Integer> st = new Stack<>();
		for(String tkn : tokens){
			int pre = 0;
			int nxt = 0;
			switch(tkn){
				case "+":
					st.push(st.pop()+st.pop());
					break;
				case "-":
					 pre = st.pop();
					 nxt = st.pop();
					st.push(nxt - pre);
					break;
				case "*":
					st.push(st.pop()*st.pop());
					break;
				case "/":
					 pre = st.pop();
					 nxt = st.pop();
					st.push(nxt / pre);
					break;
				default:
					st.push(Integer.parseInt(tkn));
					break;
			}
		}
		return st.pop();
	}
}
