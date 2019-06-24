package arrayANDstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class LengthOfLongestSubstring {
	
	
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for(int i = 0; i<n; i++){
			for(int j = i+1; j<=n; j++){
				if(allUnique(s,i,j)) ans = Math.max(ans, j-i);
			}
		}
		return ans;
	}
	public boolean allUnique(String s, int start, int end){
		Set<Character> set = new HashSet<>();
		for(int i = start; i<end; i++){
			char c = s.charAt(i);
			if(set.contains(c)) return false;
			set.add(c);
		}
		return true;
	}
	
	 public int lengthOfLongestSubstring2(String s) {
		 if(s == null || s.length() == 0)
			 return 0;
		 if(s.length() == 1)
			 return 1;
		 String ss = "";
		 int i = 0, j = 0, max = 0;
		 char[] cs = s.toCharArray();
		 int n = cs.length;
		 while(i < n && j < n){
			 if(ss.indexOf(cs[j]) == -1){
				 ss += cs[j++];
				 max = Math.max(max, ss.length());
			 }else{
				 i = ss.indexOf(cs[j]);
				 if((i+1) == ss.length())
					 ss = "";
				 else
					 ss = ss.substring(i+1,ss.length());
			 }
			 System.out.println(ss);
		 }
		 return max;
	 }
	 public int lengthOfLongestSubstring3(String s) {
		 int n = s.length();
		 Set<Character> set = new HashSet<>();
		 int ans = 0, i = 0, j = 0;
		 while(i < n && j < n){
			 if(!set.contains(s.charAt(j))){
				 set.add(s.charAt(j++));
				 ans = Math.max(ans, j-i);
			 }else
				 set.remove(s.charAt(i++));
		 }
		 return ans;
	 }
	 
	 public int lengthOfLongestSubstring4(String s) {
		 int n = s.length(), ans = 0;
		 Map<Character, Integer> map = new HashMap<>();
		 for(int j = 0, i=0; j<n; j++){
			 if(map.containsKey(s.charAt(j))){
				 i = Math.max(map.get(s.charAt(j)), i);
			 }
			 ans = Math.max(ans, j-i+1);
			 map.put(s.charAt(j), j+1);
		 }
		 return ans;
	 }
	 public int lengthOfLongestSubstring5(String s) {
	        int n = s.length(), ans = 0;
	        int[] index = new int[128]; 
	        for (int j = 0, i = 0; j < n; j++) {
	            i = Math.max(index[s.charAt(j)], i);
	            ans = Math.max(ans, j - i + 1);
	            index[s.charAt(j)] = j + 1;
	        }
	        return ans;
	 }
	 @Test
	 public void test(){
		 byte[] b = new byte[5];
		 for(byte bb : b){
			 System.out.println(bb);
		 }
		 String s = "abcabcbb";
		 int res = lengthOfLongestSubstring(s);
		 System.out.println(res);
	 }
}
