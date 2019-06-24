package randon;

import java.util.LinkedList;

public class AddBinary {
	public static String addBinary(String a, String b) {
		LinkedList<String> link = new LinkedList<>();
		int flag = 0;
		if(a.length() < b.length()){
			String tmp = a;
			a = b;
			b = tmp;
		}
		for(int i = 1; i<=a.length(); i++){
			char ac = a.charAt(a.length()-i);
			char bc = '0';
			if(b.length() - i >= 0)
				bc = b.charAt(b.length()-i);
//			System.out.println(ac + "  " + bc + " " + flag);
			int tm = ac-'0' + bc-'0' + flag;
			System.out.println(tm);
			if(tm == 3){
				flag = 1;
				link.addFirst(""+1);
			}else if(tm == 2){
				flag = 1;
				link.addFirst(""+0);
			}else if(tm == 1){
				flag = 0;
				link.addFirst(""+1);
			}else{
				flag = 0;
				link.addFirst(""+0);
			}
		}
		if(flag == 1)
			link.addFirst(""+1);
		StringBuilder res = new StringBuilder();
		for(String s : link){
			res.append(s);
		}
		return res.toString();
	}
	
	
	public static String addBinary1(String a, String b) {
		String res = "";
		int i = a.length()-1, j = b.length()-1;
		int flag = 0;
		while(i >= 0 || j >= 0){
			int digit = flag;
			if(i >= 0) digit += a.charAt(i--) - '0';
			if(j >= 0) digit += b.charAt(j--) - '0';
			res += digit % 2;
			flag = digit / 2;
		}
		if(flag != 0) res += flag;
		return new StringBuffer(res).reverse().toString();
	}
	
	public static void main(String[] args) {
//		String  a = "11", b = "1";
//		String res = addBinary1(a, b);
//		System.out.println(res);
//		 byte[] bb = {112, 121, 116, 104, 111, 110, 58, 32, 99, 97, 110, 39, 116, 32, 111, 112, 101, 110, 32, 102, 105, 108, 101, 32, 39, 47, 111, 112, 116, 47, 107, 109, 105, 112, 47, 100, 101, 109, 111, 115, 47, 112, 105, 101, 47, 103, 101, 116, 95, 106, 97, 118, 97, 46, 112, 121, 39, 58, 32, 91, 69, 114, 114, 110, 111, 32, 50, 93, 32, 78, 111, 32, 115, 117, 99, 104, 32, 102, 105, 108, 101, 32, 111, 114, 32, 100, 105, 114, 101, 99, 116, 111, 114, 121, 10};
//		 byte[] bb = {84, 114, 97, 99, 101, 98, 97, 99, 107, 32, 40, 109, 111, 115, 116, 32, 114, 101, 99, 101, 110, 116, 32, 99, 97, 108, 108, 32, 108, 97, 115, 116, 41, 58, 10, 32, 32, 70, 105, 108, 101, 32, 34, 47, 111, 112, 116, 47, 107, 109, 105, 112, 47, 100, 101, 109, 111, 115, 47, 112, 105, 101, 47, 103, 101, 116, 95, 106, 97, 118, 97, 46, 112, 121, 34, 44, 32, 108, 105, 110, 101, 32, 49, 57, 44, 32, 105, 110, 32, 60, 109, 111, 100, 117, 108, 101, 62, 10, 32, 32, 32, 32, 102, 114, 111, 109, 32, 107, 109, 105, 112, 46, 99, 111, 114, 101, 32, 105, 109, 112, 111, 114, 116, 32, 101, 110, 117, 109, 115, 10, 73, 109, 112, 111, 114, 116, 69, 114, 114, 111, 114, 58, 32, 78, 111, 32, 109, 111, 100, 117, 108, 101, 32, 110, 97, 109, 101, 100, 32, 107, 109, 105, 112, 46, 99, 111, 114, 101, 10};

		byte[] bb = {50, 48, 49, 57, 45, 48, 51, 45, 49, 55, 32, 49, 53, 58, 52, 52, 58, 51, 55, 44, 50, 57, 48, 32, 45, 32, 100, 101, 109, 111, 32, 45, 32, 69, 82, 82, 79, 82, 32, 45, 32, 91, 69, 114, 114, 110, 111, 32, 49, 51, 93, 32, 80, 101, 114, 109, 105, 115, 115, 105, 111, 110, 32, 100, 101, 110, 105, 101, 100, 58, 32, 39, 47, 104, 111, 109, 101, 47, 111, 109, 109, 47, 108, 111, 103, 46, 116, 120, 116, 39, 10};
		for(byte b : bb){
			System.out.print((char)b);
		}
	}
}
