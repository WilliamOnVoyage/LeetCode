
package algorithm.string;

import java.util.*;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		char[] p = pattern.toCharArray();
		HashMap<Character, String> map = new HashMap<>();
		if (words.length != p.length) {
			return false;
		}
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(p[i])) {
				if (!words[i].equals(map.get(p[i])))
					return false;
			} else {
				if (map.containsValue(words[i]))
					return false;
				map.put(p[i], words[i]);
			}
		}
		return true;
	}

	public boolean wordPatternMatch(String pattern, String str) {
		return wordPatternMatch_bp(new HashMap<>(), pattern, str);
	}

	public boolean wordPatternMatch_bp(HashMap<Character, String> map, String pattern, String str) {
		if (pattern.length() == 0 && str.length() == 0)
			return true;
		if (pattern.length() != 0 && str.length() != 0) {
			char p = pattern.charAt(0);
			if (map.containsKey(p)) {
				if (str.startsWith(map.get(p))) {
					return wordPatternMatch_bp(map, pattern.substring(1), str.substring(map.get(p).length()));
				} else {
					return false;
				}
			} else {
				for (int i = 1; i <= str.length(); i++) {
					String s = str.substring(0, i);
					if (map.containsValue(s))
						continue;
					map.put(p, s);
					if (wordPatternMatch_bp(map, pattern.substring(1), str.substring(i))) {
						return true;
					} else {
						map.remove(p);
					}
				}
			}
		}
		return false;
	}
}
