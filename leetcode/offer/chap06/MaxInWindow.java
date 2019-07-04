package chap06;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxInWindow {
	public static void maxInwindow(int[] A, int n){
		if(null == A || A.length <= 0 || n <= 0 || n > A.length) return;
		List<Integer> res = new ArrayList<>();
		Deque<Integer> index = new LinkedList<>();
		for(int i = 0; i<n; i++){
			while(!index.isEmpty() && A[i] >= A[index.getLast()])
				index.removeLast();
			index.addLast(i);
		}
		for(int i = n; i<A.length; i++){
			res.add(A[index.getFirst()]);
			while(!index.isEmpty() && A[i] >= A[index.getLast()])
				index.removeLast();
			if(!index.isEmpty() && index.getFirst() <= (i - n))
				index.removeFirst();
			index.addLast(i);
		}
		res.add(A[index.getFirst()]);
		System.out.println(res);
	} 
	
	public static void main(String[] args) {
		int[] A = {2,3,4,2,6,2,5,1};
		maxInwindow(A, 3);
	}
}
