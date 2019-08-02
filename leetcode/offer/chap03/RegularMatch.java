package chap03;

public class RegularMatch {
	public boolean match(String text, String pat){
		if(pat.isEmpty()) return text.isEmpty();
		boolean fm = (!text.isEmpty() && (text.charAt(0) == pat.charAt(0) || pat.charAt(0) == '.'));
		if(pat.length() >=2 && pat.charAt(1) == '*'){
			return (fm && match(text.substring(1), pat)) || match(text, pat.substring(2));
		}else{
			return fm && match(text.substring(1), pat.substring(1));
		}
	}
	
	public static void main(String[] args) {
		String res = "";
		System.out.println(res.isEmpty());
	}
}
