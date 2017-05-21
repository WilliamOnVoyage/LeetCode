
package algorithm.string;

import java.util.*;

public class GroupShiftString {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> r = new ArrayList<>();
		HashMap<Integer, HashMap<String, List<String>>> map = new HashMap<>();
		for (String s : strings) {
			HashMap<String, List<String>> samelength = map.getOrDefault(s.length(), new HashMap<>());
			String seq = cal_shift(s);
			List<String> list = samelength.getOrDefault(seq, new ArrayList<>());
			list.add(s);
			samelength.put(seq, list);
			map.put(s.length(), samelength);
		}
		for (int length : map.keySet()) {
			for (String seq : map.get(length).keySet()) {
				r.add(map.get(length).get(seq));
			}
		}
		return r;
	}

	private String cal_shift(String s) {
		char[] S = s.toCharArray();
		char[] seq = new char[S.length - 1];
		for (int i = 1; i < S.length; i++) {
			int dif = (S[i] - S[i - 1]);
			dif = dif < 0 ? dif += 26 : dif;
			seq[i - 1] = (char) dif;
		}
		return new String(seq);
	}
}