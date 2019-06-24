package other;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        if(null == s || s.length() == 0)
            return true;
        Stack<Character> out = new Stack<>();
        for(int i = s.length() - 1; i >= 0; i--){
        	char c = s.charAt(i);
        	if(c == ')' || c == '}' || c == ']'){
        		out.push(c);
        		continue;
        	}
        	if(out.isEmpty())
        		return false;
        	switch(c){
        		case '(':
        			if(out.pop() != ')')
        				return false;
        		break;
        		case '{':
        			if(out.pop() != '}')
        				return false;
        		break;
        		case '[':
        			if(out.pop() != ']')
        				return false;
        		break;
        	}
        }
        if(out.isEmpty())
        	return true;
        return false;
    }
	
	public static void main(String[] args) {
		ValidParentheses v = new ValidParentheses();
		String s = "(){}{}{{[]}}";
		boolean is = v.isValid(s);
		System.out.println(is);
	}
}
