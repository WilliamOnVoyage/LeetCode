package algorithm.recursionDP;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> r = new ArrayList<>();
		if (n >= 1) {
			int lastbit = 0;
			for (Integer i : grayCode(n - 1)) {
				r.add((i << 1) + lastbit);
				lastbit = lastbit ^ 1;
				r.add((i << 1) + lastbit);
			}
		} else if (n == 0) {
			r.add(0);
		}
		return r;
	}
}
