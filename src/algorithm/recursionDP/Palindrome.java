package algorithm.recursionDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Palindrome {

	HashMap<String, Boolean> palin;

	public List<List<String>> partition(String s) {
		palin = new HashMap<String, Boolean>();
		List<List<String>> r = new ArrayList<>();
		if (s.length() == 0)
			return r;
		Pat(s, r, new ArrayList<>());
		return r;
	}

	private void Pat(String s, List<List<String>> r, List<String> temp) {
		if (s.length() < 1) {
			r.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String str = s.substring(0, i);
			if (checkPalindrome(str, 0, str.length() - 1)) {
				temp.add(str);
				Pat(s.substring(i, s.length()), r, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private boolean checkPalindrome_dp(String s) {
		if (palin.containsKey(s))
			return palin.get(s);
		if (s.length() < 2) {
			palin.put(s, true);
			return true;
		}
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			boolean c = checkPalindrome_dp(s.substring(1, s.length() - 1));
			palin.put(s, c);
			return c;
		} else {
			palin.put(s, false);
			return false;
		}
	}

	private boolean checkPalindrome(String s, int lo, int hi) {
		if (lo == hi)
			return true;
		while (lo < hi) {
			if (s.charAt(lo) != s.charAt(hi))
				return false;
			lo++;
			hi--;
		}
		return true;
	}

}
