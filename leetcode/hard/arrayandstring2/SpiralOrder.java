package arrayandstring2;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res= new ArrayList<>();
		if(matrix == null || matrix.length == 0)
			return res;
		int m = matrix.length;
		int n = matrix[0].length;
		if(n == 0){
			for(int i = 0; i<m; i++){
				res.add(matrix[i][0]);
			}
			return res;
		}
		int cir = m > n ? n/2 : m/2;
		for(int count = 0; count<=cir; count++){
			int innerLenCol = n - count*2;
			int innerLenRow = m - count*2;
			if(innerLenCol <= 0 || innerLenRow <= 0)
				break;
			int i = count;
			int j;
			if(innerLenCol == 1){
				for(j = i; i<m-count; i++){
					res.add(matrix[i][j]);
				}
				break;
			}
			if(innerLenRow == 1){
				for(j = i; j<n-count; j++){
					res.add(matrix[i][j]);
				}
				break;
			}
			for(j = i; j<n-count; j++){
				res.add(matrix[i][j]); 
			}
			j = j-1;
			for(i = i+1; i<m-count; i++){
				res.add(matrix[i][j]);
			}
			i=i-1;
			for(j = j-1; j>=count; j--){
				res.add(matrix[i][j]);
			}
			j++;
			for(i = i-1; i>count; i--){
				res.add(matrix[i][j]);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] ss = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		List<Integer> ll = spiralOrder(ss);
		System.out.println(ll);
//		System.out.println(Arrays.toString(ss));
	}
}
