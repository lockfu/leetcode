package google;

import java.util.Arrays;
import java.util.Scanner;

public class Tranning {
	public static void train(int time, int[] nums, int p){
		int n = nums.length;
		int[] tnum = new int[n-1];	
		Arrays.sort(nums);
		for(int i = 1; i<n; i++){
			tnum[i-1] = nums[i] - nums[i-1];
		}
		int st = 0, nx = 0, min = tnum[st];
		for(int i = 0; i<p-2; i++){
			nx++;
			min+=tnum[nx];
		}
		int l = st, r = nx;
		while(nx < tnum.length){
			nx++;
			if(nx >= tnum.length)
				break;
			int tmp = min - tnum[st] + tnum[nx];
			if(tmp < min){
				l = ++st;
				r = nx;
				min = tmp;
			}else
				st++;
		}
		r = r + 1;
		int sum = 0;
		for(int i = l; i<r; i++){
			sum += nums[r] - nums[i];
		}
		System.out.println("Case #"+time+": " + sum);
	}
	
	public static void solve(Scanner in) {
		int t = in.nextInt();
		for (int q = 0; q < t; q++) {
			long ans = Long.MAX_VALUE;
			int n = in.nextInt();
			int p = in.nextInt();
			long[] a = new long[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
			Arrays.sort(a);
			long sum = 0;
			for (int i = 0; i < p; i++) {
				sum += a[i];
			}
			ans = a[p - 1] * p - sum;
			for (int i = p; i < a.length; i++) {
				sum += a[i] - a[i - p];
				ans = Math.min(a[i] * p - sum, ans);
			}
			System.out.println("Case #" + (q + 1) + ": " + ans);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++){
			int n = sc.nextInt();
			int p = sc.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i<n; i++){
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			int sum = 0;
			for(int i = 0; i<p; i++){
				sum += nums[i];
			}
			int ans = nums[p-1] * p - sum;
			for(int i = p; i<n; i++){
				sum += nums[i]-nums[i-p];
				ans = Math.min(nums[i]*p - sum, ans);
			}
			System.out.println("Case #" + t + ": " + ans);
		}
	}
}
