package chap03;

public class IsNumric {
	public static boolean isNum(String str){
		if(str == null) return false;
		str = scanInteger(str);
		if(str.isEmpty()) return true;
		char cur = str.charAt(0);
		if(cur != '.' && (cur != 'e' && cur != 'E')) return false;
		if(str.charAt(0) == '.'){
			str = str.substring(1);
			str = scanUnsignInteger(str);
		}
		if(str.isEmpty()) return true;
		if(str.length()==1) return false;
		if(str.charAt(0) == 'e' || str.charAt(0) == 'E'){
			str = str.substring(1);
			str = scanInteger(str);
		} 
		return str.isEmpty();
	}
	
	public static String scanInteger(String str){
		if(str.charAt(0) == '+' || str.charAt(0) == '-')
			str = str.substring(1);
		return scanUnsignInteger(str);
	}
	
	public static String scanUnsignInteger(String str){
		while(!str.isEmpty() && str.charAt(0) >= '0' && str.charAt(0) <= '9')
			str = str.substring(1);
		return str;
	}
	
	public static void main(String[] args) {
		String str = "12e";
		boolean res = isNum(str);
		System.out.println(res);
	}
}
