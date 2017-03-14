package algorithm;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
	public List<String> letterCombinations(String digits) {
		List<String> r = new ArrayList<>();
		if (digits.length() == 0)
			return r;
		char[] dig = digits.toCharArray();
		char[] letter = get_letter(dig[dig.length - 1] - '0');
		r = combine(letter, letterCombinations(digits.substring(0, digits.length() - 1)));
		return r;
	}

	private List<String> combine(char[] l, List<String> prev) {
		if (l == null)
			return prev;
		List<String> r = new ArrayList<>();
		if (prev == null || prev.size() == 0) {
			for (char c : l) {
				r.add(Character.toString(c));
			}
		} else {
			for (String s : prev) {
				for (char c : l) {
					r.add(s + c);
				}
			}
		}
		return r;
	}

	private char[] get_letter(int num) {
		char[] letter;
		switch (num) {
		case 0:
			letter = new char[] { ' ' };
			break;
		case 1:
			letter = null;
			break;
		case 2:
			letter = new char[] { 'a', 'b', 'c' };
			break;
		case 3:
			letter = new char[] { 'd', 'e', 'f' };
			break;
		case 4:
			letter = new char[] { 'g', 'h', 'i' };
			break;
		case 5:
			letter = new char[] { 'j', 'k', 'l' };
			break;
		case 6:
			letter = new char[] { 'm', 'n', 'o' };
			break;
		case 7:
			letter = new char[] { 'p', 'q', 'r', 's' };
			break;
		case 8:
			letter = new char[] { 't', 'u', 'v' };
			break;
		case 9:
			letter = new char[] { 'w', 'x', 'y', 'z' };
			break;
		default:
			letter = null;
			break;
		}
		return letter;
	}
}
