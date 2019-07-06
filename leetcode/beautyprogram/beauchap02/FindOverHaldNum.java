package beauchap02;

/**
 *  找到数组中超过一半数字的哪个数
 * @author DELL
 *
 */

public class FindOverHaldNum {
	public static int find(int[] A){
		if(null == A || A.length <= 0) return -1;
		int candidate = A[0];
		int times = 1;
		for(int i = 1; i<A.length; i++){
			if(times == 0){
				candidate = A[i];
				times = 1;
			}else{
				times--;
			}
		}
		return candidate;
	}
	
	
}
