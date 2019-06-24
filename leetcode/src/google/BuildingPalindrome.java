package google;

import java.util.Scanner;

public class BuildingPalindrome {
	public static int isPlaindorm(String str){
        int[] A = new int[128];
        int len = str.length();
        boolean odd = len % 2 == 0 ? true : false;
        for(char c : str.toCharArray()){
            int cur = c - '0';
            A[cur]++;
        }
        int evn = 0;
        for(int i = 0; i<128; i++){
            if(A[i] != 0 && A[i] % 2 != 0)
                evn++;
        }
        return odd ? (evn == 0 ? 1 : 0) : (evn ==1 ? 1 : 0);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t<=T; t++){
            int N = sc.nextInt();
            int Q = sc.nextInt();
            String str = sc.next();
            int res = 0;
            for(int q = 1; q<=Q; q++){
                int l = sc.nextInt();
                int r = sc.nextInt();
                String cur = str.substring(l-1,r);
                res += isPlaindorm(cur);
            }
            System.out.println("Case #"+t+": " + res);
        }
    }
}
