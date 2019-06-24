package backtrace;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthsis {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if(n <= 0) return res;
		helper(n,n,"",res);
		return res;
	}
	private static void helper(int left, int right, String out, List<String> res){
		if(left < 0 || right < 0 || left > right) return ;
		if(left == 0 && right == 0){
			res.add(out);
			return;
		}
		helper(left-1, right, out+"(", res);
		helper(left, right-1, out+")", res);
	}
	public static void main(String[] args) {
		List<String> res = generateParenthesis(3);
		System.out.println(res.size());
		System.out.println(res);
	}
}
