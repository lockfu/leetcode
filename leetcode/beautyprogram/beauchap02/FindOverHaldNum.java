package beauchap02;

/**
 *  �ҵ������г���һ�����ֵ��ĸ���
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
