package math;

public class ReverseInteger {
	public int reverse(int x) {
		if (x == 0)
			return x;
		double res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
		}
		return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0
				: (int) res;
	}
}
