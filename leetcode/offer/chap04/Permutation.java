package chap04;

import java.util.Arrays;

public class Permutation {
	public static void permution(String str){
		if(null == str || str.length() <= 0) return;
		permu(str.toCharArray(), 0);
	}
	public static void permu(char[] cs, int begin){
		if(begin == cs.length){
			System.out.println(Arrays.toString(cs));
		}else{
			for(int i = begin; i<cs.length; i++){
				char temp = cs[i];
				cs[i] = cs[begin];
				cs[begin] = temp;
				
				permu(cs, begin+1);
				
				temp = cs[i];
				cs[i] = cs[begin];
				cs[begin] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "abc";
		permution(str);
	}
}
