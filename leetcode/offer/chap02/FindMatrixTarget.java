package chap02;

/**
 * 二维数组中的查找
 * 每一行和每一列递增 输入一个整数，求是否存在
 * @author DELL
 *
 */
public class FindMatrixTarget {
	/**
	 * 从右上顶点开始查找，如果当前值大于输入值，则当前值往下都大于，否则当前值往左都小于。
	 * @param A
	 * @param t
	 * @return
	 */
	public static boolean find(int[][] A, int t){
		if(null == A || A.length <= 0 || A[0].length <= 0) return false;
		int row = A.length, col = A[0].length;
		int r = 0, c = col - 1;
		while(r < row && c >=0){
			if(A[r][c] == t)
				return true;
			else if(A[r][c] > t)
				c--;
			else r++;
		}
		return false;
	}
	
	public static void main (String[] args) {
		int[][] A = {
				{1, 2, 8,  9},
				{2, 4, 9,  12},
				{4, 7, 10, 13},
				{6, 8, 11, 15}
		};
		boolean res = find(A,5);
		System.out.println(res);
	}
}
