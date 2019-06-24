package string;

public class MyAtoi {
	public int myAtoi(String str){
		if(str == null || str.length() == 0)
			return 0;
		str = str.trim();
		double res = 0;
		char[] cs = str.toCharArray();
		int sign = 1;
		if(cs[0] == '+')
            sign = 1;
		else if(cs[0] == '-' )
			sign = -1;
		else if(cs[0] < '0' || cs[0] > '9')
			return 0;
        else
            res = Integer.parseInt(cs[0]+"");
		
		for(int i = 1; i<cs.length; i++){
			char c = cs[i];
			if(c < '0' || c > '9')
				break;
			else
				res = res * 10 + Integer.parseInt(c+"");
		}
		res = sign*res;
		return res < Integer.MIN_VALUE ? Integer.MIN_VALUE : (res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res);
	}
}
