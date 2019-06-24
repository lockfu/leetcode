package string;

public class ReverseString {
	/**
	 * 反转字符串
	 * @param s
	 * @return
	 */
	 public static String reverseString(String s) {
		 if(s == null || s.length() == 1) 
			 return s;
		 StringBuilder sb = new StringBuilder();
		 for(int i = s.length()-1; i>=0; i--){ // 从字符串尾部开始追加
			 sb.append(s.charAt(i));
		 }
		 return sb.toString();
	 }
	
	 public String reverseString1(String s) {
	        char[] A = s.toCharArray();
			int len = A.length;
	        int start = 0; 
	        int end = len-1;
			while(start < end){
				char temp = A[start];
	            A[start] = A[end];
	            A[end] = temp;
	            end--;
	            start++;
			}
			return new String(A);
	    }
	 public static void main(String[] args) {
		 String str = "hello";
		String s = reverseString(str);
		System.out.println(s);
	}
}
