package knife.ch02;

//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

public class Doublicate {
	public static int dublicate(int[] A, int n){
//		Set<Integer> res = new HashSet<>();
		int[] tmp = new int[n];
		for(int i : A){
			tmp[i]++;
			if(tmp[i] > 1)
				return i;
//				res.add(i);
		}
		return -1;
//		return new ArrayList<>(res);
	}
	public static int dublicate2(int[] A){
		if(null == A || A.length <= 0)
			return -1;
		for(int i = 0; i<A.length; i++){
			while(A[i] != i){
				if(A[i] == A[A[i]])
					return A[i];
				int tmp = A[i];
				A[i] = A[A[i]];
				A[A[i]] = tmp;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] A = {0,2,3,0,4,5,6,7};
		int res1 = dublicate(A, 8);
		int res2 = dublicate2(A);
		System.out.println(res1 + " : " + res2);
	}
}
