package algorithm;

import java.util.Arrays;

public class LongestCommonPrefix {
	// public String longestCommonPrefix(String[] strs) {
	// return merge_LCP(strs, 0, strs.length);
	// }
	//
	// private String merge_LCP(String[] strs, int lo, int hi) {
	// if (hi == lo)
	// return "";
	// if (hi - lo == 1)
	// return strs[lo];
	// if (hi - lo == 2)
	// return LCP(strs[lo], strs[lo + 1]);
	// int mid = (lo + hi) / 2;
	// return LCP(merge_LCP(strs, lo, mid), merge_LCP(strs, mid, hi));
	// }
	//
	// private String LCP(String str1, String str2) {
	// if (str1 == "")
	// return str2;
	// if (str2 == "")
	// return str1;
	// StringBuilder c = new StringBuilder();
	// char[] c1 = str1.toCharArray();
	// char[] c2 = str2.toCharArray();
	// for (int i = 0; i < c1.length && i < c2.length; i++) {
	// if (c1[i] != c2[i])
	// break;
	// c.append(c1[i]);
	// }
	// return c.toString();
	// }

	public String longestCommonPrefix(String[] strs) {
		StringBuilder result = new StringBuilder();

		if (strs != null && strs.length > 0) {

			Arrays.sort(strs);

			char[] a = strs[0].toCharArray();
			char[] b = strs[strs.length - 1].toCharArray();

			for (int i = 0; i < a.length; i++) {
				if (b.length > i && b[i] == a[i]) {
					result.append(b[i]);
				} else {
					return result.toString();
				}
			}
		}
		return result.toString();
	}
}
