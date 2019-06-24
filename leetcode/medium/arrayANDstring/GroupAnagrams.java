package arrayANDstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if(strs == null || strs.length == 0)
			return res;
		List<String> contains = new ArrayList<>();
		List<String> tmp = new ArrayList<>();
		for(int i = 0; i<strs.length; i++){
			if(!contains.contains(strs[i])){
				tmp = new ArrayList<>();
				tmp.add(strs[i]);
				contains.add(strs[i]);
			}else
				continue;
			for(int j = i+1; j<strs.length; j++){
				if(isAnagram(strs[i],strs[j])){
					tmp.add(strs[j]);
					contains.add(strs[j]);
				}
			}
			res.add(tmp);
		}
		return res;
	}
	public boolean isAnagram(String s, String t){
		if(s.equals(t))
			return true;
		if(s.length() != t.length())
			return false;
		int[] cs = new int[26];
		for(int i = 0; i<s.length(); i++){
			cs[s.charAt(i)-'a']++;
		}
		for(int i = 0; i<s.length(); i++){
			cs[t.charAt(i)-'a']--;
		}
		for(int i = 0; i<cs.length; i++){
			if(cs[i] != 0)
				return false;
		}
		return true;
	}
	public List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if(strs == null || strs.length == 0)
			return res;
		String[] strstmp = new String[strs.length];
		for(int i = 0; i<strs.length; i++){
			char[] cs = strs[i].toCharArray();
			Arrays.sort(cs);
			StringBuilder sb = new StringBuilder();
			for(char c : cs){
				sb.append(c+"");
			}
			strstmp[i] = sb.toString();
		}
		List<String> contains = new ArrayList<>();
		List<String> tmp = new ArrayList<>();
		for(int i = 0; i<strs.length; i++){
			if(!contains.contains(strs[i])){
				tmp = new ArrayList<>();
				tmp.add(strs[i]);
				contains.add(strs[i]);
			}else
				continue;
			for(int j = i+1; j<strs.length; j++){
				if(strstmp[i].equals(strstmp[j])){
					tmp.add(strs[j]);
					contains.add(strs[j]);
				}
			}
			res.add(tmp);
		}
		return res;
	}
	public List<List<String>> groupAnagrams3(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if(strs == null || strs.length == 0)
			return res;
		Map<String, List<String>> map = new HashMap<>();
		for(String s : strs){
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String tmp = new String(ch);
			if(map.containsKey(tmp))
				map.get(tmp).add(s);
			else{
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(tmp, list);
			}
		}
//		for(Map.Entry<String, List<String>> en : map.entrySet()){
//			res.add(en.getValue());
//		}
		res.addAll(map.values());
		return res;
	}
}
