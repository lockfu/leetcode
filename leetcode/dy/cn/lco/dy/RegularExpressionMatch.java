package cn.lco.dy;

public class RegularExpressionMatch {
	public boolean isMatch(String text, String pattern) {
		if(pattern.isEmpty()) return text.isEmpty();
		boolean fm = (!text.isEmpty() && pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');
		if(pattern.length() >= 2 && pattern.charAt(1) == '*')
			return (isMatch(text, pattern.substring(2)) || fm && isMatch(text.substring(1), pattern));
		else
			return fm && isMatch(text.substring(1), pattern.substring(1));
	}
	
	public boolean isMatch_dy(String text, String pattern) {
		if(pattern.isEmpty()) return text.isEmpty();
		boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
		dp[text.length()][pattern.length()] = true;
		for(int i = text.length(); i>=0; i--){
			for(int j = pattern.length()-1; j>=0; j--){
				boolean fm = (i<text.length() && text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
				if(j+1 < pattern.length() && pattern.charAt(j+1) == '*')
					dp[i][j] = dp[i][j+2] || (fm &&dp[i+1][j]);
				else
					dp[i][j] = fm && dp[i+1][j+1];
			}
		}
		return dp[0][0];
	}
}
