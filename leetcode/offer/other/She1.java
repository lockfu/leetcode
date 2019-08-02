package other;

import java.util.Scanner;

public class She1 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		while (sc.hasNext()) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//			long[][] path = new long[x + 1][y + 1];
//			int n = sc.nextInt();
//			for (int i = 0; i < n; i++) {
//				int a = sc.nextInt();
//				int b = sc.nextInt();
//				path[a][b] = -1;
//			}
//
//			for (int i = 0; i <= x; i++) {
//				path[i][0] = 1;
//			}
//			for (int j = 0; j <= y; j++) {
//				path[0][j] = 1;
//			}
//			for (int i = 1; i <= x; i++) {
//				for (int j = 1; j <= y; j++) {
//					if (path[i][j] == -1) {
//						path[i][j] = 0;
//					} else {
//						path[i][j] = path[i][j - 1] + path[i - 1][j];
//					}
//				}
//			}
//			System.out.println(path[x][y]);
//		}
//	}
	
	
	public static int res = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        int[][] A = new int[x+1][y+1];
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            A[a][b] = -1;
        }
        boolean[][] walked = new boolean[x+1][y+1];
        dfs(A, x, y, walked);
        System.out.println(res);
    }
    public static int[][] next = {
				{-1, 0},
				{0, -1}
	};
    public static void dfs(int[][] A, int x, int y, boolean[][] walked){
		if(x == 0 && y == 0){
			res++;
			return;
		}
		for(int i = 0; i<next.length; i++){
			int dx = x + next[i][0];
			int dy = y + next[i][1];
			if(dx < 0 || dx >= A.length || dy < 0 || dy >= A[0].length || walked[dx][dy] || A[dx][dy] == -1) continue;
			walked[dx][dy] = true;
			dfs(A, dx, dy, walked);
			walked[dx][dy] = false;
		}
	}
//	
//	public static int res = 0;
//	public static void dfs(int[][] A, int x, int y, boolean[][] walked){
//		if(x == 0 && y == 0){
//			res++;
//			return;
//		}
//		int[][] next = {
//				{-1, 0},
//				{0, -1}
//		};
//		for(int i = 0; i<next.length; i++){
//			int dx = x + next[i][0];
//			int dy = y + next[i][1];
//			if(dx < 0 || dx >= A.length || dy < 0 || dy >= A[0].length || walked[dx][dy] || A[dx][dy] == -1) continue;
//			walked[dx][dy] = true;
//			dfs(A, dx, dy, walked);
//			walked[dx][dy] = false;
//		}
//	}
//	
//	public static void main(String[] args) {
//		int[][] A = {
//				{0,0,0,0},
//				{0,-1,0,0},
//				{0,0,-1,0},
//				{0,0,0,0}
//		};
//		boolean[][] walked = new boolean[4][4];
//		dfs(A, 3, 3, walked);
//		System.out.println(res);
//	}
}
