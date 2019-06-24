package top100;

public class WildCardMatch {
	public boolean isMatch(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
		int i = 0, j = 0, istar = -1, jstar = -1;
		while(i < s.length()){
			if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
				++i; ++j;
			}else if(j < p.length() && p.charAt(j) == '*'){
				istar = i;
				jstar = j++;
			}else if(istar >= 0){
				i = ++istar;
				j = jstar + 1;
			}else 
				return false;
		}
		while(j<p.length() && p.charAt(j) == '*') ++j;
		return j == p.length();
	}
	
	public boolean isMatch_dy(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
		boolean[][] match = new boolean[s.length()+1][p.length()+1];
		match[0][0] = true;
		for(int i = 1; i<p.length(); i++)
			if(p.charAt(i-1) == '*')
				match[0][i] = match[0][i-1];
		for(int i = 1; i<=s.length(); i++){
			for(int j = 1; j<=p.length(); j++){
				if(p.charAt(j-1) != '*')
					match[i][j] = match[i-1][j-1] &&  (p.charAt(j-1)=='?' || s.charAt(i-1)== p.charAt(j-1));
				else
					match[i][j] = match[i][j-1] || match[i-1][j];
			}
		}
		return match[s.length()][p.length()];
	}
}
