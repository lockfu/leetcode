package chap05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNum {
	
	
	public static String printMinNum_1(int[] A){
		if(null == A || A.length <= 0) return "";
		ArrayList<Integer> list = new ArrayList<>();
		for(int item : A){
			list.add(item);
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer str1, Integer str2) {
				String s1 = str1+""+str2;
				String s2 = str2+""+str1;
				return s1.compareTo(s2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i : list){
			sb.append(i);
		}
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		int[] A = {3,5,1,4,2};
//		printMinNum(A);
//		String[] ss = {"3", "32", "321"};
		String[] ss = {"3","5","1","4","2"};
		Arrays.sort(ss);
		System.out.println(Arrays.toString(ss));
		
	}
}
