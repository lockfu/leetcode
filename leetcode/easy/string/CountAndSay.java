package string;

public class CountAndSay {
	public String countAndSay(int n) {
		if(n <= 0)
			return null;
		if(n==1)
			return "1";
		if(n==2)
			return "11";
		String s = "11";
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 3; i<=n; i++){
			char cur = s.charAt(0);
			count = 1;
			for(int j = 1; j<s.length(); j++){
				if(cur != s.charAt(j)){
					sb.append(count+""+cur);
					cur = s.charAt(j);
					count = 1;
				}else{
					count++;
				}
			}
			sb.append(count+""+s.charAt(s.length()-1));
			s = sb.toString();
			sb = new StringBuilder();
		}
		return s;
	}
}
