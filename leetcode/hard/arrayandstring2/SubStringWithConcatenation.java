package arrayandstring2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringWithConcatenation {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(null == s || null == words || words.length <= 0) return res;
        int len = words.length, wordlen = words[0].length();
        int totallen = len * wordlen;
        if(totallen > s.length()) return res;
        int l=0, r = totallen;
        while(r <= s.length()){
            String cur = s.substring(l, r);
            if(isSuccess1(cur, words))
                res.add(l);
            l++;r++;
        }
        return res;
    }
	
	public boolean isSuccess1(String s, String[] words){
        int len = words[0].length();
        for(int i = 0; i<words.length; i++){
        	String cur = words[i];
        	int curindex = s.indexOf(cur);
        	if(curindex == -1) return false;
        	while(curindex % len != 0){
        		curindex = s.indexOf(cur, curindex+1);
        		if(curindex == -1) return false;
        	}
        	s = curindex == 0 ? s.substring(curindex+len) : s.substring(0,curindex) + s.substring(curindex+len);
        }
        return s.length() == 0;
    }
	
    public boolean isSuccess(String s, String[] words){
        Set<Integer> set = new HashSet<>();
        int len = words[0].length();
        int l = 0, r = len;
        while(r <= s.length()){
            String cur = s.substring(l,r);
            for(int i = 0; i<words.length; i++){
                if(set.contains(i)) continue;
                if(cur.equals(words[i])) {
                	set.add(i);
                	break;
                }
            }
            l = r;
            r = r + len;
        }
        return set.size() == words.length;
    }
    
    public static void main(String[] args) {
    	SubStringWithConcatenation sm = new SubStringWithConcatenation();
    	String s = "ababaab"; //"wordgoodgoodgoodbestword"; //"barfoothefoobarman"; // "wordgoodgoodgoodbestword";
    	String[] words = {"ab","ba","ba"};//{"word","good","best","good"};//{"foo","bar"};//{"word","good","best","word"};
    	
    	List<Integer> res = sm.findSubstring(s, words);
    	System.out.println(res);
//    	boolean ress = sm.isSuccess1("ababaa", words);
//    	System.out.println(ress);
    	
	}
}
