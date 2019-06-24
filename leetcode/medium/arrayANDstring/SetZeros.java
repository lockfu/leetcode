package arrayANDstring;

import java.util.HashSet;
import java.util.Set;

public class SetZeros {
	public void setZeroes(int[][] matrix) {
		if(matrix == null)
			return ;
		Set<Integer> row = new HashSet<>();
		Set<Integer> col = new HashSet<>();
		
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				if(matrix[i][j] == 0){
					row.add(i);
					col.add(j);
				}
			}
		}
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				if(row.contains(i) || col.contains(j)){
					matrix[i][j] = 0;
				}
			}
		}
	}
	public void setZeroes1(int[][] matrix) {
		if(matrix == null)
			return ;
		int MODIFIED = -1000;
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				if(matrix[i][j] == 0){
					for(int k = 0; k<matrix[i].length; k++){
						if(matrix[i][k] != 0)
							matrix[i][k] = MODIFIED;
					}
					for(int k = 0; k<matrix.length; k++){
						if(matrix[k][j] != 0)
							matrix[k][j] = MODIFIED;
					}
				}
			}
		}
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				if(matrix[i][j] == MODIFIED){
					matrix[i][j] = 0;
				}
			}
		}
	}
	public void setZeroes2(int[][] matrix) {
		if(matrix == null)
			return ;
		boolean isCol = false;
		for(int i = 0; i<matrix.length; i++){
			if(matrix[i][0] == 0) isCol = true;
			for(int j = 1; j<matrix[0].length; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for(int i = 1; i<matrix.length; i++){
			for(int j = 1; j<matrix[0].length; j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0){
					matrix[i][j] = 0;
				}
			}
		}
		
		if(matrix[0][0] == 0)
			for(int j = 0; j<matrix[0].length; j++)
				matrix[0][j] = 0;
		if(isCol)
			for(int i = 0; i<matrix.length; i++)
				matrix[i][0] = 0;
	}
}
