package chap05;

public class NumOf1Bet1ToN {
	public static int numof1(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += countOne(n);
		}
		return sum;
	}

	public static int countOne(int n) {
		int res = 0;
		while (n != 0) {
			if (n % 10 == 1)
				res++;
			n = n / 10;
		}
		return res;
	}


	public static int countOfone(int n) {
		int res = 0, fac = 1, low = 0, cur = 0, hi = 0;
		while (n / fac != 0) {
			low = n - (n / fac) * fac;
			cur = (n / fac) % 10;
			hi = n / (fac * 10);
			switch (cur) {
			case 0:
				res += hi * fac;
				break;
			case 1:
				res += hi * fac + low + 1;
				break;
			default:
				res += (hi + 1) * fac;
				break;
			}
			fac *= 10;
		}
		return res;
	}

	public static void main(String[] args) {
		int res = countOfone(23);
		System.out.println(res);
	}
}
