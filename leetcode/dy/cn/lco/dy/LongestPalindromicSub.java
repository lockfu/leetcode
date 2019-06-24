package cn.lco.dy;

public class LongestPalindromicSub {
	public String longestPalindrome(String s) {
		if(null == s || s.length() <= 1) return s;
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		int st = 0, ed = 0, max_len = 0;
		for(int i = 0; i<len; i++){
			 dp[i][i] = true;
			for(int j = 0; j<i; j++){
				if(i == j) dp[i][j] = true;
				else{
					dp[j][i] = (s.charAt(i) == s.charAt(j)) && (dp[j+1][i-1] || i-j < 2);
					if(dp[j][i] && max_len < i-j+1){
						max_len = i-j+1;
						st = j;
						ed = i;
					}
				}
			}
		}
		return s.substring(st,ed+1);
	}
	
	
	 public String longestPalindrome1(String s) {
		 if(s == null || s.length() < 1) return "";
		 int start = 0, end = 0;
		 for(int i = 0; i<s.length(); i++){
		 	int len1 = expandAroundCenter(s,i,i);
		 	int len2 = expandAroundCenter(s,i,i+1);
		 	int len = Math.max(len1, len2);
		 	if(len > end - start){
		 		start = i - (len-1)/2;
		 		end = i + len/2;
		 	}
		 }
		 return s.substring(start,end+1);
	  }
	    
	 public int expandAroundCenter(String s, int left, int right){
	 	int l = left, r = right;
	 	while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
	 		l--;
	 		r++;
	 	}
	 	return r-l-1;
	 }
}
