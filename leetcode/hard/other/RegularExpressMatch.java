package other;

public class RegularExpressMatch {
	public static boolean isMatch(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
		boolean fm = (!s.isEmpty() && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.'));
		if(p.length() >=2 && p.charAt(1) == '*')
			return (isMatch(s, p.substring(2)) || (fm && isMatch(s.substring(1), p)));
		else
			return fm && isMatch(s.substring(1), p.substring(1));
	}
	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		boolean res = isMatch(s,p);
		System.out.println(res);
	}
}
