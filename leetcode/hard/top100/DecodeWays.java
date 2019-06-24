package top100;



public class DecodeWays {
	public int numDecodings(String s) {
		int size = s.length();
		if(size == 0)
			return 0;
		int[] dp = new int[size+1];
		dp[0] = 1;
		dp[1] = (s.charAt(0)-'0' == 0) ? 0 : 1;
		for(int i = 2; i<=size; i++){
			if(s.charAt(i-1) != '0')
				dp[i] = dp[i-1];
			int towDis = Integer.parseInt(s.substring(i-2, i));
			if(towDis >= 10 && towDis <= 26)
				dp[i] += dp[i-2];
		}
		return dp[size];
	}
	
	public static void main(String[] args) {
		String s = "303";
		int res = new DecodeWays().numDecodings(s);
		System.out.println(res);
//		for(int i = 1; i<=300; i++){
//			System.out.println(UUID.randomUUID().toString().split("-")[0]);
//		}
		
	}
}
