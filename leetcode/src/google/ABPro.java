package google;

import java.util.ArrayList;
import java.util.List;

public class ABPro {
	public static void main(String[] args) {
//		byte i = 81;
//		while(i-- > 0){
//			if(i/9%3 == i%9%3)
//				continue;
//			System.out.println("A=" + (i/9+1) + " B="+(i%9+1) );
//		}
		
		test();
	}
	
	public static void test(){
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		List<Integer> list2 = new ArrayList<>(list1);
		list2.add(3);
		list2.add(4);
		
		System.out.println(list1);
		System.out.println(list2);
	}
}
