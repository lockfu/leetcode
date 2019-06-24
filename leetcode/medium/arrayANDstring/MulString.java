package arrayANDstring;

public class MulString {
	public String multipky(String num1, String num2){
		if(num1.equals("0") || num2.equals("0")) return "0";
		int n1 = num1.length(), n2 = num2.length();
		int[] p = new int[n1+n2];
		for(int i = 0; i<n1; i++){
			for(int j = 0; j<n2; j++){
				int d1 = (num1.charAt(n1-1-i) - '0');
				int d2 = (num2.charAt(n2-1-j) - '0');
				p[i+j] += d1*d2;
				p[i+j+1] += p[i+j] / 10;
				p[i+j] %= 10;
			}
		}
		int i = n1+n2-1;
		while(i>=0 && p[i] == 0){
			i--;
		}
		StringBuilder sb = new StringBuilder();
		while(i>=0){
			sb.append((char)('0'+p[i--]));
		}
		return sb.toString();
	}
}
