package cn.fxx.lco;

public class LongestPlainSubstring {
	public String solution(String s){
		if(s == null || s.length() <= 0) return "";
		int start = 0, end = 0;
		for(int i = 0; i<s.length(); i++){
			int len1 = expandLen(s,i,i);
			int len2 = expandLen(s,i,i+1);
			int len = len1 > len2 ? len1 : len2;
			if(len > (end - start)){
				start = i - (len-1)/2;
				end = i + len/2;
			}
		}
		return s.substring(start, end);
	}
	public int expandLen(String s, int left, int right){
		int l = left, r = right;
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
			l--;
			r++;
		}
		return r-l-1;
	}
	
	public static String solutionDy(String s){
		if(s.isEmpty()) return "";
		int len1 = s.length();
		boolean[][] dp = new boolean[len1][len1];
		int left = 0, right = 0, len = 0;
		for(int i = 0; i<len1; i++){
			dp[i][i] = true;
			for(int j = 0; j<i; ++j){
				dp[j][i] = (s.charAt(j) == s.charAt(i)) && (i-j<2 || dp[j+1][i-1]);
				if(dp[j][i] && len < i-j+1){
					len = i-j+1;
					left = j;
					right = i;
				}
			}
		}
		System.out.println(left + " " + right);
		return s.substring(left,right+1);
	}
	
	public static void main(String[] args) {
		String s = "abcdbbfcba";
		String res = solutionDy(s);
		System.out.println(res);
	}
}
