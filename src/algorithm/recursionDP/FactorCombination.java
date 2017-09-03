
package algorithm.recursionDP;

import java.util.*;

public class FactorCombination {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> r = new ArrayList<>();
		factors_dp(n, 2, r, new ArrayList<>());
		return r;
	}

	private void factors_dp(int n, int st, List<List<Integer>> r, List<Integer> f) {
		for (int i = st; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				f.add(i);
				factors_dp(n / i, i, r, f);
				f.add(n / i);
				r.add(new ArrayList<>(f));
				f.remove(f.size() - 1);
				f.remove(f.size() - 1);
			}
		}
	}
}
