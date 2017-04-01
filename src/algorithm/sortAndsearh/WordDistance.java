package algorithm.sortAndsearh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WordDistance {

	public int shortestWordDistance(String[] words, String word1, String word2) {
		int index = -1;
		int min = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
					min = Math.min(i - index, min);
				}
				index = i;
			}
		}
		return min;
	}

	HashMap<String, List<Integer>> map;

	public WordDistance(String[] words) {
		map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				map.get(words[i]).add(i);
			} else {
				List<Integer> l = new ArrayList<>();
				l.add(i);
				map.put(words[i], l);
			}
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> d1 = map.get(word1);
		List<Integer> d2 = map.get(word2);
		int dis = Integer.MAX_VALUE;
		for (int i = 0, j = 0; i < d1.size() && j < d2.size();) {
			int i1 = d1.get(i);
			int i2 = d2.get(j);
			if (i1 < i2) {
				dis = Math.min(dis, i2 - i1);
				i++;
			} else {
				dis = Math.min(dis, i1 - i2);
				j++;
			}
		}
		return dis;
	}
}
