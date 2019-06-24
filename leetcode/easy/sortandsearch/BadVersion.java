package sortandsearch;

import java.util.Arrays;

public class BadVersion {
//	 public int firstBadVersion(int n) {
//	        int l = 1, r = n;
//	        while(l < r){
//	            int mid = l + (r - l)/ 2;
//	            if(isBadVersion(mid)){
//	                r = mid;
//	            }else{
//	                l = mid + 1;
//	            }
//	        }
//	        return l;
//	    }
	
	public static void main(String[] args) {
		String key = "54a0401c60165c9ae9cb50f91ed6727f";
		byte[] bytes = key.getBytes();
		System.out.println("length: " + bytes.length);
		System.out.println("byte: " + Arrays.toString(bytes));
	}
}
