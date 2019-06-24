package google;

import java.util.Scanner;

public class TestC1 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t<=T; t++){
            int instruc = sc.nextInt();
            int row = sc.nextInt();
            int col = sc.nextInt();
            int sr = sc.nextInt();
            int sl = sc.nextInt();
            String dir = sc.next();
            int resr = sr-1, resl = sl-1;
            boolean[][] pic = new boolean[row][col];
            pic[resr][resl] = true;
            for(char c : dir.toCharArray()){
            	switch(c){
	                case 'N':
	                    while( resr > 0 && pic[resr][resl]) resr--;
	                    pic[resr][resl] = true;
	                    break;
	                case 'S':
	                    while( resr < row-1 && pic[resr][resl]) resr++;
	                    pic[resr][resl] = true;
	                    break;
	                case 'W':
	                    while(resl > 0 &&  pic[resr][resl]) resl--;
	                    pic[resr][resl] = true;
	                    break;
	                case 'E':
	                    while( resl < col-1 && pic[resr][resl]) resl++;
	                    pic[resr][resl] = true;
	                    break;
	                default: 
	                    break;
	            }
            }
            
            System.out.println("Case #"+t+": " + (resr+1) + " " + (resl+1));
        }
    }
}
