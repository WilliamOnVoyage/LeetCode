
package algorithm.recursionDP;

import java.util.*;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> r = new ArrayList<>();
		generateParenthesis_dp(r, "", 0, 0, n);
		System.out.println(r.size());
		return r;
	}

	private void generateParenthesis_dp(List<String> r, String str, int left, int right, int max) {
		if (str.length() == max * 2) {
			r.add(str);
		} else {
			if (left < max) {
				generateParenthesis_dp(r, str + "(", left + 1, right, max);
			}
			if (right < left)
				generateParenthesis_dp(r, str + ")", left, right + 1, max);
		}
	}
}