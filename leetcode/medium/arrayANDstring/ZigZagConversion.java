package arrayANDstring;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
        if(null == s || s.length() <= 0 || numRows == 1) return s;
        StringBuilder[] res = new StringBuilder[numRows];
        for(int i = 0; i<res.length; i++){
            res[i] = new StringBuilder();
        }
        int num = 0;
        boolean goDown = false;
        for(char c : s.toCharArray()){
            res[num] = res[num].append(c);
            if(num == 0 || num == numRows-1) goDown = !goDown ;
            num += goDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder item : res){
            result.append(item);
        }
        return result.toString();
    }
	
	
	public String convert1(String s, int numRows) {
        if(null == s || s.length() <= 0 || numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for(int i = 0; i<numRows; i++){
        	for(int j = 0; j+i < n; j+=cycleLen){
        		res.append(s.charAt(j+i));
        		if( i != 0 && i != numRows - 1 && j + cycleLen - i < n)
        			res.append(s.charAt(j + cycleLen - i));
        	}
        }
        return res.toString();
    }
	
	
}
