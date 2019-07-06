package chap02;

/**
 * ���޸��ҳ��ظ�������
 * ����Ϊ1+n�������е�����������1-n��Χ�С��ҵ�����һ���ظ�������
 * ʹ�ö��ֲ��ҵķ�������1-n�����ֽ��л��֣��鿴ÿ����е��������������е�������
 * ������ڵĵ�ǰ��ߵ�ֵ�Ļ�����ô���߾����ظ������֡�
 * @author DELL
 *
 */
public class DuplicateArrNoModify_02 {
	public static int getDupllicate(int[] A){
		if(null == A || A.length <= 1) return -1;
		int st = 1;
		int end = A.length-1;
		while(st <= end){
			int mid = st + (end - st) / 2;
			int count = countRange(A, st, mid);
			if(st == end){
				if(count > 1)
					return st;
				else
					break;
			}
			if(count > (mid - st + 1))
				end = mid;
			else
				st = mid+1;
		}
		return -1;
	}
	
	public static int countRange(int[] A, int st, int end){
		int count = 0;
		for(int i = 0; i<A.length; i++){
			if(A[i] >= st && A[i] <= end)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] A = {2,3,5,4,3,2,6,7};
		int res = getDupllicate(A);
		System.out.println(res);
	}
}
