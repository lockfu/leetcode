package top100;

import java.util.Arrays;

public class PerfectSquares {
	/**
	 * ��ƽ���Ͷ���
	 * ������ƽ���Ͷ�������һ�����������ɱ�ʾΪ4��������ƽ���ͣ���ʵ�ǿ��Ա�ʾΪ4�����ڵ�ƽ����֮�ͣ���ô����˵���ؽ��ֻ��1,2,3��4���е�һ��
	 * ����һ���������������4����ô���ǿ��԰�4��ȥ��������Ӱ����
	 * ���һ��������8��7�Ļ�����ô�϶�����4����ȫƽ�������
	 * @param n
	 * @return
	 */
	public int numSquares(int n) {
		while(n % 4 == 0) n = n/4;
		if(n % 8 == 7) return 4;
		for(int a = 0; a*a <= n; ++a){
			int b = (int) Math.sqrt(n-a*a);
			if((a*a + b*b) == n){
				if(a!=0 && b != 0)
					return 2;
				else
					return 1;
			}
		}
        return 3;
    }
	
	
	public int numSquares_dp(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, n+1);
		dp[0] = 0;
		for(int i = 0; i<=n; i++){
			for(int j = 1; i+j*j <= n; j++){
				dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
			}
		}
		return dp[n];
    }
}
