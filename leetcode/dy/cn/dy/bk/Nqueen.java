package cn.dy.bk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nqueen {
	public List<List<String>> nQueen(int n){
		List<List<String>> res = new ArrayList<>();
		int[][] b = new int[n][n];
		Set<String> remain = new HashSet<>();
		solve(b,1,n,res, remain);
		return res;
	}
	public void solve(int[][] b, int t, int n, List<List<String>> res, Set<String> remain){
		if(t > n){
			List<String> tmp = new ArrayList<>();
			StringBuilder longsb = new StringBuilder();
			for(int i = 0; i< n; i++){
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j<n; j++){
					if(b[i][j] == 0)
						sb.append(".");
					else
						sb.append("Q");
				}
				longsb.append(sb.toString());
				tmp.add(sb.toString());
			}
			if(!remain.contains(longsb.toString())){
				remain.add(longsb.toString());
				res.add(tmp);
			}
		}else{
			for(int i = 0; i< n; i++){
				for(int j = 0; j<n; j++){
					if(validFill(b, i, j)){
						b[i][j] = 1;
						solve(b,t+1, n, res, remain);
						b[i][j] = 0;
					}
				}
			}
		}
	}
	
	public boolean validFill(int[][] board, int r, int c){
		if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
		if(board[r][c] != 0) return false;
		for(int i = 0; i<board.length; i++){
			if(board[r][i] != 0 || board[i][c] != 0) return false;
		}
		for(int i = 1; i<board.length; i++){
			if((r-i) >= 0 && (c-i) >= 0)  // вСио╫г
				if(board[r-i][c-i] != 0) return false;
			if((r+i) < board.length && (c-i) >= 0)  // вСоб╫г
				if(board[r+i][c-i] != 0) return false;
			if((r-i) >= 0 && (c+i) < board.length)  // срио╫г
				if(board[r-i][c+i] != 0) return false;
			if((r+i) < board.length && (c+i) < board.length)  // сроб╫г
				if(board[r+i][c+i] != 0) return false;
		}
		return true;
	}
	
	
	// ---------------------------------------
	private Set<Integer> col = new HashSet<>();
	private Set<Integer> diag1 = new HashSet<>();
	private Set<Integer> diag2 = new HashSet<>();
	
	public List<List<String>> nQueen2(int n){
		List<List<String>> res = new ArrayList<>();
		solve2(res, new ArrayList<String>(), 0, n);
		return res;
	}
	public void solve2(List<List<String>> res, List<String> cur, int row, int n){
		if(row == n){
			res.add(new ArrayList<>(cur));
			return;
		}
		for(int i = 0; i<n; i++){
			if(col.contains(i) || diag1.contains(row+i) || diag2.contains(row-i)) continue;
			char[] cs = new char[n];
			Arrays.fill(cs, '.');
			cs[i] = 'Q';
			String rowString = new String(cs);
			cur.add(rowString);
			col.add(i);
			diag1.add(row+i);
			diag2.add(row-i);
			
			solve2(res, cur, row+1, n);
			
			cur.remove(cur.size()-1);
			col.remove(i);
			diag1.remove(row+i);
			diag2.remove(row-i);
		}
	}
	
//	 	private Set<Integer> col = new HashSet<Integer>();
//	    private Set<Integer> diag1 = new HashSet<Integer>();
//	    private Set<Integer> diag2 = new HashSet<Integer>();
	    
	    public List<List<String>> solveNQueens(int n) {
	        List<List<String>> res = new ArrayList<List<String>>();
	        dfs(res,new ArrayList<String>(), 0, n);
	        return res;
	    }
	    private void dfs(List<List<String>> res, List<String> list, int row, int n){
	        if (row == n){
	            res.add(new ArrayList<String>(list));
	            return;
	        }
	        for (int i = 0; i < n; i++){
	            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
	            
	            char[] charArray = new char[n];
	            Arrays.fill(charArray, '.');
	            charArray[i] = 'Q';
	            String rowString = new String(charArray);
	            
	            list.add(rowString);
	            col.add(i);
	            diag1.add(row + i);
	            diag2.add(row - i);
	            
	            dfs(res, list, row + 1, n);
	            
	            list.remove(list.size() - 1);
	            col.remove(i);
	            diag1.remove(row + i);
	            diag2.remove(row - i);
	        }
	    }
	
	
	public static void main(String[] args) {
		Nqueen nq = new Nqueen();
//		List<List<String>> res = nq.nQueen(7);
		List<List<String>> res = nq.nQueen2(4);
//		List<List<String>> res = nq.solveNQueens(4);
		System.out.println(res.size());
		for(List<String> item : res){
			System.out.println(item);
			System.out.println();
		}
		
	}
}
