package top100;

import java.util.ArrayList;
import java.util.List;

public class PlaindromPart {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		ArrayList<String> tmp = new ArrayList<>();
		boolean[][] A = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (i - j <= 2 || A[j + 1][i - 1]))
					A[j][i] = true;
			}
		}
		helper(s, 0, tmp, res, A);
		return res;
	}

	public void helper(String s, int start, List<String> tmp,
			List<List<String>> res, boolean[][] dp) {
		if (start == s.length()) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (dp[start][i]) {
				tmp.add(s.substring(start, i + 1));
				helper(s, i + 1, tmp, res, dp);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

	public boolean isPalindrom(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			++start;
			--end;
		}
		return true;
	}

	public boolean[][] allPlain(String s) {
		int len = s.length();
		boolean[][] A = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			A[i][i] = true;
		}
		for (int i = 0; i < len; i++) {
			int l = i - 1;
			int r = i;
			while (l >= 0 && r < len && s.charAt(l) == s.charAt(r))
				A[l--][r++] = true;
			l = i - 1;
			r = i + 1;
			while (l >= 0 && r < len && s.charAt(l) == s.charAt(r))
				A[l--][r++] = true;
		}
		return A;
	}

	public static void main(String[] args) {
		PlaindromPart pp = new PlaindromPart();
		String s = "abacabg";
		boolean b = pp.isPalindrom(s, 2, 4);
		System.out.println(b);
	}
}
