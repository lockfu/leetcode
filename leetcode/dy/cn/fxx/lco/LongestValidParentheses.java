package cn.fxx.lco;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        if(null == s || s.length() <= 1) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for(int i = 0; i<s.length(); i++){
        	if(s.charAt(i) == '(')
        		st.push(i);
        	else{
        		st.pop();
        		if(st.isEmpty())
        			st.push(i);
        		else
        			max = Math.max(max, i - st.peek());
        	}
        }
        return max;
    }
	
	public int longestValidParentheses_dy(String s) {
        if(null == s || s.length() <= 1) return 0;
        int max = 0;
        int[] dp = new int[s.length()];
        for(int i = 1; i<s.length(); i++){
        	if(s.charAt(i) == ')'){
        		if(s.charAt(i-1) == '(')
        			dp[i] = (i>=2 ? dp[i-1] : 0 ) + 2;
        		else if(i-dp[i-1] >0 && s.charAt(i - dp[i-1] -1) == '('){
        			dp[i] = dp[i-1] + ((i - dp[i-1] >=2 ? dp[i-dp[i-1]-2]: 0)) + 2;
        		}
        		max = Math.max(max, dp[i]);
        	}
        }
        return max;
    }
}
