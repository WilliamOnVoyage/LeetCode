
package algorithm.string;

import java.util.*;

public class LongestUncommonSubsequence {
	public int findLUSlength(String a, String b) {
		return a.equals(b) ? -1 : Math.max(a.length(), b.length());
	}

	public int findLUSlength(String[] strs) {
		int length = -1;

		return length;
	}
}