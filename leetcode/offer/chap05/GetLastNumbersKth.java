package chap05;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class GetLastNumbersKth {
	
	public static int partiton(int[] A, int start, int end){
		if(null == A || A.length <= 0 || start < 0 || end >= A.length)
			throw new IllegalArgumentException("Illegal Augument!!!");
		int base = A[start];
		int i = start, j = end;
		while(i < j){
			while(i < j && A[j] >= base) j--;
			while(i < j && A[i] <= base) i++;
			if(i<j){
				A[i] = A[i] ^ A[j];
				A[j] = A[i] ^ A[j];
				A[i] = A[i] ^ A[j];
			}
		}
		A[start] = A[i];
		A[i] = base;
		return i;
	}
	
	public static int[] getKthSmall(int[] A, int k){
		if(null == A || A.length <= 0 || k <= 0 ) return null;
		if(k >= A.length) return A;
		int[] res = new int[k];
		int l = 0, r = A.length-1;
		int index = partiton(A, l, r);
		while(index != k-1){
			if(index > k-1){
				r = index - 1;
				index = partiton(A, l, r);
			}else{
				l = index + 1;
				index = partiton(A, l, r);
			}
		}
		for(int i = 0; i<k; i++){
			res[i] = A[i];
		}
		return res;
	}
	
	public static int[] getKthSmall_dump(int[] A, int k){
		if(null == A || A.length <= 0 || k <= 0 ) return null;
		if(k >= A.length) return A;
		int[] res = new int[k];
		
		TreeSet<Integer> tset = new TreeSet<>();
		for(int item : A){
			if(tset.size() < k){
				tset.add(item);
			}else{
				if(item < tset.last()){
					tset.remove(tset.last());
					tset.add(item);
				}
			}
		}
		Iterator<Integer> itor = tset.iterator();
		int c = 0;
		while(itor.hasNext()){
			Integer item = itor.next();
			res[c++] = item;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int[] A = {4,5,1,6,2,7,3,8};
//		int[] res = getKthSmall(A, 4);
//		System.out.println(Arrays.toString(res));
		
		int[] res = getKthSmall_dump(A, 4);
		System.out.println(Arrays.toString(res));
		
//		TreeSet<Integer> tset = new TreeSet<>();
//		tset.add(3);
//		tset.add(10);
//		tset.add(5);
//		tset.add(2);
//		tset.add(20);
//		
//		System.out.println(tset.first() + "  " + tset.last());
		
	}
}
