package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, List<String>> anagram = new HashMap<>();
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String label = new String(c);
			if (anagram.containsKey(label)) {
				List<String> l = anagram.get(label);
				l.add(s);
				anagram.put(label, l);
			} else {
				anagram.put(label, new ArrayList<String>(Arrays.asList(s)));
			}
		}
		for (String label : anagram.keySet()) {
			result.add(anagram.get(label));
		}
		return result;
	}
}
