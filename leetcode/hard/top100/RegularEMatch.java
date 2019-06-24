package top100;

public class RegularEMatch {
	public boolean isMatch(String s, String p) {
		if(s == null && p == null)
			return true;
		if(p.equals(".*"))
			return true;
		int pindex = 0;
		for(int i = 0; i<s.length(); ){
			if(pindex >= p.length())
				return false;
			if((s.charAt(i) == p.charAt(pindex)) || p.charAt(pindex)=='.'){
				pindex++;
				i++;
				continue;
			}else{
				if(p.charAt(pindex) != '*'){
					if((pindex >= (p.length()-1)) || (p.charAt(++pindex) != '*'))
						return false;
					else
						pindex++;
				}else{  // cur is *
					if(pindex==0)
						pindex++;
					else{
						char pre = p.charAt(pindex-1);
						if(s.charAt(i) == pre || pre == '.'){
							if(i == s.length()-1 && pindex == p.length()-1)
								return true;
							if(i == s.length()-1 && ++pindex == p.length()-1 && s.charAt(i)==p.charAt(pindex))
								return true;
							i++;
							continue;
						}else
							pindex++;
					}
				}
			}
		}
		return pindex == p.length() ? true : false;
    }
	public static void main(String[] args) {
		RegularEMatch r = new RegularEMatch();
		String s = "aaa"; 
		String p = "a*";
		boolean res = r.isMatch1(s, p);
		System.out.println(res);
	}
	
	// ----------------------
	public boolean isMatch1(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
		boolean f_m = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
		if(p.length() >= 2 && p.charAt(1) == '*')
			return (isMatch1(s, p.substring(2)) || (f_m && isMatch1(s.substring(1), p)));
		else
			return f_m && isMatch1(s.substring(1), p.substring(1));
	}
	
	public boolean isMatch_dy(String s, String p) {
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[s.length()][p.length()] = true;
		for(int i = s.length(); i>=0; i--){
			for(int j = p.length()-1; j>=0; j--){
				boolean f_m = (i<s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
				if(j+1 < p.length() && p.charAt(j+1) == '*')
					dp[i][j] = dp[i][j+2] || f_m && dp[i+1][j];
				else
					dp[i][j] = f_m && dp[i+1][j+1];
			}
		}
		return dp[0][0];
	}
	
	
	
}
