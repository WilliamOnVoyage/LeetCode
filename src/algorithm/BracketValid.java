package algorithm;

import java.util.Stack;

public class BracketValid {
	public boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		int[] brack = new int[128];
		int count = 0;
		while (count < s.length()) {
			char c = s.charAt(count);
			if (c == ')' || c == ']' || c == '}') {
				char item = (char) st.pop();
				while (!st.isEmpty() && item != (char) (c - 2) && item != (char) (c - 1)) {
					brack[item]--;
					item = (char) st.pop();
				}
				if (item == (char) (c - 2) || item == (char) (c - 1)) {
					brack[item]--;
					if (brack['('] != 0 || brack['['] != 0 || brack['{'] != 0)
						return false;
				}
			} else {
				brack[c]++;
				st.push(c);
			}
			count++;
		}
		return (brack['('] == 0 && brack['['] == 0 && brack['{'] == 0);
	}
}
