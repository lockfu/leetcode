package string;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 1)
			return strs[0];
		int minLen = Integer.MAX_VALUE;
		for(String s : strs){
			if(s.length() < minLen)
				minLen = s.length();
		}
		String res = "";
		for(int i = 0; i<minLen; i++){
			boolean isSame = false;
			for(int j = 0; j<strs.length-1; j++){
				if(strs[j].charAt(i) != strs[j+1].charAt(i)){
					isSame = false;
					return res;
				}else{
					isSame = true;
				}
			}
			if(isSame)
				res += strs[0].charAt(i);
		}
		return res;
	}
	
	public String longestCommonPrefix_preh(String[] strs) {
		if(null == strs || strs.length <= 0) return "";
		if(strs.length == 1)
			return strs[0];
		String s = strs[0];
		for(int i = 1; i<strs.length; i++){
			while(!strs[i].startsWith(s)){
				s = s.substring(0, s.length()-1);
			}
		}
		return s;
	}
	public String longestCommonPrefix_prev(String[] strs) {
		if(null == strs || strs.length <= 0) return "";
		if(strs.length == 1)
			return strs[0];
		for(int i = 0; i<strs[0].length(); i++){
			char c = strs[0].charAt(i);
			for(int j = 1; j<strs.length; j++){
				if(i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0,i);
			}
		}
		return strs[0];
	}
}
