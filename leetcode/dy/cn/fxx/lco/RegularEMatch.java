package cn.fxx.lco;

public class RegularEMatch {
	public boolean isMatch(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
		boolean fm = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'); 
		if(p.length() >= 2 && p.charAt(1) == '*'){
			return isMatch(s, p.substring(2)) || fm && isMatch(s.substring(1), p);
		}else{
			return fm && isMatch(s.substring(1), p.substring(1));
		}
	}
	public boolean isMatch_dp(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
		boolean[][] dp = new boolean[s.length() + 1][p.length()+1];
		dp[s.length()][p.length()] = true;
		for(int i = s.length(); i>=0; i--){
			for(int j = p.length()-1; j>=0; j--){
				boolean fm = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')); 
				if(j+1 < p.length() && p.charAt(j+1) == '*')
					dp[i][j] = dp[i][j+2] || dp[i+1][j];
				else
					dp[i][j] = fm && dp[i+1][j+1];
			}
		}
		return dp[0][0];
	}
	
}
