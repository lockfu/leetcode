package arrayandstring2;

import java.util.Stack;

import org.junit.Test;

public class Calculate {
	public int calculate(String s) {
		StringBuilder sb = new StringBuilder();
		char[] cs = s.toCharArray();
		for(char c : cs){
			if(!(c == ' '))
				sb.append(c);
		}
		
		Stack<String> stack = new Stack<>();
		s = sb.toString();
		cs = s.toCharArray();
		for(int i = 0; i<cs.length;){
			switch (cs[i]) {
			case '*':
			case '/':
				char cc = cs[i];
				int pre = Integer.parseInt(stack.pop());
				sb = new StringBuilder();
				i++;
				while(i < cs.length && cs[i] >= '0' && cs[i] <= '9'){
					sb.append(cs[i]);
					i++;
				}
				int nxt = Integer.parseInt(sb.toString());
				if(cc == '*')
					stack.push((pre * nxt)+"");
				else 
					stack.push((pre / nxt)+"");
				break;
			case '+':
			case '-':
				stack.push(cs[i]+"");
				i++;
				break;
				
			default:
				sb = new StringBuilder();
				while(i < cs.length && cs[i] >= '0' && cs[i] <= '9'){
					sb.append(cs[i]);
					i++;
				}
				stack.push(sb.toString());
				break;
			}
		}
		Stack<String> copyStack = new Stack<>();
		while(!stack.isEmpty()){
			copyStack.push(stack.pop());
		}
		int res = 0;
		while(copyStack.size()!=1){
			int pre = Integer.parseInt(copyStack.pop());
			String op = copyStack.pop();
			int ntx = Integer.parseInt(copyStack.pop());
			if(op.equals("-"))
				res = (pre - ntx);
			else if(op.equals("+"))
				res = (pre+ntx);
			copyStack.push(res+"");
		}
		return Integer.parseInt(copyStack.pop());
	}
	
	
	public int calculate1(String s){
		int result = 0, pre = 0;
		char sign = '+';
		char[] str = s.toCharArray();
		for(int i = 0; i< str.length; i++){
			if(str[i] == ' ') continue;
			int num = 0 ;
			if(str[i] >= '0' && str[i] <= '9'){
				while(i < str.length && str[i] >= '0' && str[i] <= '9')
					num = num * 10 + (str[i++] - '0');
			}
			if(sign == '+'){
				result += pre;
				pre = num;
			}else if(sign == '-'){
				result += pre;
				pre = -num;
			}else if(sign == '*'){
				pre *= num;
			}else
				pre /= num;
			while(i<str.length && str[i] == ' ')
				i++;
			if(i<str.length)
				sign = str[i];
		}
		return result + pre;
	}
	
	
	
	
	@Test
	public void test(){
		String s = "0-2134343";
		int res = calculate(s);
		System.out.println(res);
	}
}
