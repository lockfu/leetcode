package chap02;

/**
 * һ������Ϊn�����飬 ������0-n-1֮�� �ҳ��ظ�������
 * @author DELL
 *
 */

public class DuplicateArr_01 {
	public static int duplicate(int[] A){
		if(null == A || A.length <= 1)
			return -1;
		for(int item : A){  // �������С��0���ߴ���n-1 �������������
			if(item < 0 || item > A.length-1)
				return -1;
		}
		for(int i = 0; i<A.length; i++){  // Ϊÿ��Ԫ���ҵ���ȷ��λ��
			while(A[i] != i){		    // ��ǰԪ�ز�����ȷ��λ����һֱѭ��
				if(A[i] == A[A[i]])     // ���i == A[i] ��ȣ� ˵����ǰλ����Ԫ���ˣ����ظ�Ԫ��
					return A[i];
				int temp = A[i];        // ���򽻻�Ԫ��
				A[i] = A[temp];
				A[temp] = temp;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {2,3,1,0,2,5,3};
		int res = duplicate(A);
		System.out.println(res);
	}
}
