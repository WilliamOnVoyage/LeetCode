package algorithm.recursionDP;

import java.util.HashMap;
import java.util.List;

public class WordBreak {

	private HashMap<String, Boolean> map = new HashMap<>();

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.length() == 0)
			return false;
		if (map.containsKey(s))
			return map.get(s);
		for (int i = 0; i < wordDict.size(); i++) {
			String word = wordDict.get(i);
			if (word.length() <= s.length()) {
				if (s.equals(word)) {
					map.put(s, true);
					return true;
				}
				if (s.contains(word)) {
					int st = s.indexOf(word);
					String l_s = s.substring(0, st);
					String r_s = s.substring(st + word.length(), s.length());
					if ((wordBreak(l_s, wordDict) || l_s.length() == 0) && (wordBreak(r_s, wordDict) || r_s.length() == 0)) {
						map.put(s, true);
						return true;
					}
				}
			}
		}
		map.put(s, false);
		return false;
	}
}
