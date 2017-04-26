package algorithm;

public class LicenseKey {
	public String licenseKeyFormatting(String S, int K) {
		int count = 0;
		String[] str = S.split("-");
		for (String s : str) {
			count += s.length();
		}
		char[] ch = S.toCharArray();
		char[] r = new char[count + (count - 1) / K];

		int ch_i = ch.length - 1, r_i = r.length - 1;
		int r_count = 1;
		while (ch_i >= 0 && r_i >= 0) {
			if (ch[ch_i] == '-') {
				ch_i--;
				continue;
			}
			if (r_count % (K + 1) == 0) {
				r[r_i] = '-';
			} else {
				r[r_i] = Character.toUpperCase(ch[ch_i]);
				ch_i--;
			}
			r_i--;
			r_count++;
		}
		return new String(r);
	}
}
