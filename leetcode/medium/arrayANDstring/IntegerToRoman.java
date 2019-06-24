package arrayANDstring;

public class IntegerToRoman {
	public static String intToRoman(int num) {
//		char[] roman = {'I','V','X','L','C','D','M'};
        if(num <= 0) return "";
        int bei = 0;
        StringBuilder sb = new StringBuilder();
        while(num != 0){
        	int tmp = (num % 10);
        	System.out.println(tmp);
        	if(tmp != 0){
	        	switch(bei){
		        	case 0:
		        		if(tmp <= 3){
		        			for(int i = 0; i<tmp; i++)
		        				sb.append("I");
		        		}
		        		else if(tmp == 4) sb.append("VI");
		        		else if(tmp == 5) sb.append("V");
		        		else if(tmp <= 8){
		        			for(int i = 5; i<tmp; i++)
		        				sb.append("I");
		        			sb.append("V");
		        		} 
		        		else if(tmp == 9) sb.append("XI");
		        		break;
		        	case 1:
		        		if(tmp <= 3){
		        			for(int i = 0; i<tmp; i++)
		        				sb.append("X");
		        		}
		        		else if(tmp == 4) sb.append("LX");
		        		else if(tmp == 5) sb.append("L");
		        		else if(tmp <= 8){
		        			for(int i = 5; i<tmp; i++)
		        				sb.append("X");
		        			sb.append("L");
		        		} 
		        		else if(tmp == 9) sb.append("CX");
		        		break;
		        	case 2:
		        		if(tmp <= 3){
		        			for(int i = 0; i<tmp; i++)
		        				sb.append("C");
		        		}
		        		else if(tmp == 4) sb.append("DC");
		        		else if(tmp == 5) sb.append("D");
		        		else if(tmp <= 8){
		        			for(int i = 5; i<tmp; i++)
		        				sb.append("C");
		        			sb.append("D");
		        		} 
		        		else if(tmp == 9) sb.append("MC");
		        		break;
		        	case 3:
		        		if(tmp <= 3){
		        			for(int i = 0; i<tmp; i++)
		        				sb.append("M");
		        		}
		        		break;
	        	}
        	}
        	bei++;
        	num = num / 10;
        }
        return sb.reverse().toString();
	}
	
	public static String intToRoman_y(int num) {
		StringBuilder sb = new StringBuilder();
		int[] value = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		int n = value.length;
		for(int i = n-1; i>=0; i--){
			if(num >= value[i]){
				int count = num / value[i];
				num %= value[i];
				while(count-- > 0)
					sb.append(symbol[i]);
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		int num = 4;
		String res = intToRoman_y(num);
		System.out.println(res);
	}
}
