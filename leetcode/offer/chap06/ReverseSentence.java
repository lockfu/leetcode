package chap06;

public class ReverseSentence {
	public static void reverseSentence(String str){
		if(null == str || str.length() <= 0) return;
		String[] ss = str.split(" ");
		int st = 0, ed = ss.length-1;
		while(st < ed){
			String tmp = ss[st];
			ss[st] = ss[ed];
			ss[ed] = tmp;
			st++;
			ed--;
		}
		StringBuilder sb = new StringBuilder();
		for(String item : ss){
			sb.append(item);
			sb.append(" ");
		}
		System.out.println(sb.substring(0, sb.length()-1));
	}
	
	public static void main(String[] args) {
		String str = "I am a student.";
		reverseSentence(str);
	}
}
