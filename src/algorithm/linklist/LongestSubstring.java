package algorithm.linklist;

import java.util.*;
import java.util.Map.Entry;

public class LongestSubstring {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (k < 1 || s.length() < 1)
			return 0;
		if(k>=128)
			return s.length();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		int left = 0, right = 0, maxlen = 0;
		char[] ch = s.toCharArray();
		while (true) {
			// Less than k duplicates, move on
			while (map.size() <= k && right < ch.length) {
				if (map.containsKey(ch[right])) {
					maxlen = Math.max(maxlen, right - left + 1);
					map.remove(ch[right]);
				} else if (map.size() < k) {
					maxlen = Math.max(maxlen, right - left + 1);
				}
				map.put(ch[right], right);
				right++;
			}
			if (right == ch.length)
				break;
			// Remove the first set of duplicates (first/oldest of linked hashmap), left start from its right
			int index = map.entrySet().iterator().next().getValue();
			left = index + 1;
			char key = map.entrySet().iterator().next().getKey();
			map.remove(key);
		}
		return maxlen;
	}
}
