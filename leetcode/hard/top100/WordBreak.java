package top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		for(String item : wordDict){
			if(s.equals(item))
				return true;
			else if(s.startsWith(item))
				res.add(item);
		}
		if(res.size() <= 0)
			return false;
		int size = res.size();
		while(size > 0){
			List<String> tmp = new ArrayList<>();
			for(String item : res){
				for(String ii : wordDict){
					String cur = item + ii;
					if(s.equals(cur))
						return true;
					else if(s.startsWith(cur))
						tmp.add(cur);
				}
			}
			res = new ArrayList<>(tmp);
			size = res.size();
		}
		return false;
	}
	public boolean wordBreak_dp(String s, List<String> wordDict) {
		if(s == null || s.length() == 0) return false;
		int n = s.length();
		boolean[] dp = new boolean[n];
		for(int i = 0; i<s.length(); i++){
			for(int j = 0; j <= i; j++){
				String sub = s.substring(j,i+1);
				if(wordDict.contains(sub) && (j==0 || dp[j-1])){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n-1];
	}
	
	private boolean dfs(String s, List<String> wordDict, Set<String> visited){
		if(s.length() == 0) return true;
		if(visited.contains(s)) return false;
		for(String word : wordDict){
			if(s.startsWith(word) && dfs(s.substring(word.length()), wordDict, visited))
				return true;
		}
		visited.add(s);
		return false;
	}
	
//	private boolean helper(String s,  List<String> wordDict){
//		for(String item : wordDict){
//			if(s.equals(item))
//				return true;
//			else if(s.startsWith(item)){
//				return helper(s.substring(item.length()), wordDict);
//			}
//		}
//		return false;
//	}
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("car");
		wordDict.add("ca");
		wordDict.add("rs");
		boolean res = new WordBreak().wordBreak_dp("cars", wordDict);
		System.out.println(res);
	}
}
