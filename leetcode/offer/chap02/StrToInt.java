package chap02;

public class StrToInt {
	public static int StrToInt(String str) {
		if (null == str || str.length() <= 0)
			return 0;
		int sign = 1;
		if (str.charAt(0) == '-') {
			sign = -1;
			str = str.substring(1);
		} else if (str.charAt(0) == '+')
			str = str.substring(1);
		int fac = 1;
		long res = 0;
		
		for (int i = str.length()-1; i >= 0; i--) {
			char cur = str.charAt(i);
			if (cur < '0' || cur > '9')
				return 0;
			res += fac * (cur - '0');
			fac *= 10;
		}
		res = sign * res;
		return (res > Integer.MAX_VALUE) ? Integer.MAX_VALUE
				: (res < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) res);
	}

	public static void main(String[] args) {
		String str = "123";
		int res = StrToInt(str);
		System.out.println(res);
	}
}
