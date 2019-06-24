package top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		if(null == s || s.length() == 0) return res;
		int n = s.length();
		boolean[] dp = new boolean[n];
		for(int i = 0; i<n; i++){
			for(int j = 0; j<=i; j++){
				String tmp = s.substring(j,i+1);
				if(wordDict.contains(tmp) && (j == 0 || dp[j-1])){
					dp[i] = true;
					break;
				}
			}
		}
		if(!dp[n-1])
			return res;
		dfs(res, dp, s, 0, wordDict, "");
		return res;
	}
	private void dfs(List<String> res, boolean[] dp, String s, int start,List<String> wordDict, String ts){
		if(start >= dp.length) {
			res.add(ts);
			return;
		}
		for(int i = start; i<dp.length; i++){
			if(dp[i]){
				String tmp = s.substring(start, i+1);
				if(wordDict.contains(tmp)){
					String newts = (ts.length() > 0 ? ts + " " + tmp : tmp);
					dfs( res, dp,  s, i+1,wordDict, newts);
				}
			}
		}
	}
	
	private final Map<String, List<String>> cache = new HashMap<>();
	private boolean containsSuffix(List<String> wordDict, String str){
		for(int i = 0; i<str.length(); i++){
			if(wordDict.contains(str.substring(i))) return true;
		}
		return false;
	}
	public List<String> wb(String s, List<String> wordDict){
		if(cache.containsKey(s)) return cache.get(s);
		List<String> result = new LinkedList<>();
		if(wordDict.contains(s)) result.add(s);
		for(int i = 1; i<s.length(); i++){
			String left = s.substring(0,i), right = s.substring(i);
			if(wordDict.contains(left) && containsSuffix(wordDict, right)){
				for(String ss : wb(right,wordDict)){
					result.add(left + " " + ss);
				}
			}
		}
		cache.put(s, result);
		return result;
	}
	
	// --------------------------------------
	private void helper(String s, List<String> wordDict, int start, String ts, List<String> res){
		if(start >= s.length()){
			res.add(ts);
			return;
		}
		StringBuilder str = new StringBuilder();
		for(int i = start; i<s.length(); i++){
			str.append(s.charAt(i));
			if(wordDict.contains(str.toString())){
				String newItem = ts.length() >0 ? (ts+" " + str.toString()) : str.toString();
				helper(s, wordDict, i+1, newItem, res);
			}
		}
	}
	
	
	int maxlen = 0;
	public List<String> wordBreakAccepted(String s, List<String> wordDict){
		Set<String> hs = new HashSet<>();
		for(String w : wordDict){
			hs.add(w);
			if(w.length() > maxlen) maxlen = w.length();
		}
		Map<Integer, List<String>> map = new HashMap<>();
		return helperAccepted(hs,s,0,map);
	}
	
	public List<String> helperAccepted(Set<String> hs,String s,int start,Map<Integer, List<String>> map){
		if(map.containsKey(start)) return map.get(start);
		
		List<String> list = new ArrayList<>();
		if(start == s.length()) list.add("");
		for(int i = start; i<start+maxlen && i<s.length(); i++){
			if(hs.contains(s.substring(start, i+1))){
				List<String> nexts = helperAccepted(hs, s, i+1, map);
				for(String next : nexts){
					list.add(next == "" ? s.substring(start, i+1) : (s.substring(start, i+1) + " " + next));
				}
			}
		}
		map.put(start, list);
		return list;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
//		wordDict.add("cat");
//		wordDict.add("cats");
//		wordDict.add("and");
//		wordDict.add("sand");
//		wordDict.add("dog");
		wordDict.add("apple");
		wordDict.add("pen");
		wordDict.add("applepen");
		wordDict.add("pine");
		wordDict.add("pineapple");
		List<String> res = new WordBreak2().wordBreak("pineapplepenapple", wordDict);
		System.out.println("size: " + res.size());
		for(String item : res){
			System.out.println(item);
		}
	}
}
