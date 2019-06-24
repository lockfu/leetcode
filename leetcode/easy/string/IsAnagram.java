package string;

public class IsAnagram {
	public boolean isAnagram(String s, String t){
		if(s == null && t == null)
			return true;
		if(s == null || t == null)
			return false;
		int[] A = new int[26];
		for(char c : s.toCharArray()){
			A[c-'a']++;
		}
		for(char c : t.toCharArray()){
			A[c - 'a']--;
		}
		for(int i : A){
			if(i != 0)
				return false;
		}
		return true;
	}
}
