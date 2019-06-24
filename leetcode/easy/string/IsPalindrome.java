package string;

public class IsPalindrome {
	public boolean isPalindrome(String s) {
		if(s == null)
			return false;
		if("" == s || s.length() == 0)
			return true;
		
		s = s.toLowerCase();
		char[] c = s.toCharArray();
		int l = 0, h = c.length-1;
		while(l<=h){
			char cl = c[l];
			char cr = c[h];
			if(!((cl >= 'a' && cl <= 'z') || (cl >= '0' && cl <= '9'))){
				l++;
				continue;
			}
			if(!((cr >= 'a' && cr <= 'z') || (cr >= '0' && cr <= '9'))){
				h--;
				continue;
			}
			if(cl == cr){
				l++;
				h--;
			}else{
				return false;
			}
		}
		return true;
	}
}
