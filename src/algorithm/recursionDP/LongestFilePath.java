package algorithm.recursionDP;

import java.util.Stack;

public class LongestFilePath {
	// public int lengthLongestPath(String input) {
	// Stack<Integer> length = new Stack<>();
	// length.push(0);
	// int max = 0;
	// for (String s : input.split("\n")) {
	// int level = s.lastIndexOf("\t") + 1;
	// while (level + 1 < length.size())
	// length.pop();
	// int cur = length.peek() + s.length() - level + 1;
	// length.push(cur);
	// if (s.contains("."))
	// max = Math.max(max, cur - 1);
	// }
	// return max;
	// }

	public int lengthLongestPath(String input) {
		String[] path = input.split("\n");
		int[] length = new int[path.length + 1];
		int max = 0;
		for (String s : path) {
			int level = s.lastIndexOf("\t") + 1;
			int cur = length[level] + s.length() - level + 1;
			length[level + 1] = cur;
			if (s.contains("."))
				max = Math.max(max, cur - 1);
		}
		return max;
	}
}
