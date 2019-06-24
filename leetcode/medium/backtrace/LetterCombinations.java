package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
	public List<String> letterCombinations(String digits) {
		LinkedList<String> res = new LinkedList<>();
		if(digits.isEmpty()) return res;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.add("");
		while(res.peek().length() != digits.length()){
			String remove = res.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c : map.toCharArray()){
				res.add(remove+c);
			}
		}
		return new ArrayList<>(res);
	}
	String[] mapping_s = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	List<String> out = new ArrayList<>();
	public void bk(String combin, String next_digits){
		if(next_digits.length() == 0)
			out.add(combin);
		else{
			char digit = next_digits.charAt(0);
			String s = mapping_s[digit-'0'];
			for(char c : s.toCharArray()){
				bk(combin+c, next_digits.substring(1));
			}
		}
	}
	public List<String> letterCombinations1(String digits) {
		if(digits.length() != 0)
			bk("", digits);
		return out;
	}
	
	public static void main(String[] args) {
		LetterCombinations ll = new LetterCombinations();
		String s = "23";
		List<String> res = ll.letterCombinations(s);
		List<String> res2 = ll.letterCombinations1(s);
		System.out.println(res);
		System.out.println(res2);
	}
}
