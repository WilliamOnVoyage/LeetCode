package algorithm.recursionDP;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		return subsets_dp(nums, nums.length);
	}

	private List<List<Integer>> subsets_dp(int[] nums, int ed) {
		List<List<Integer>> r = new ArrayList<>();
		if (ed != 0 && nums != null) {
			int end = nums[ed - 1];
			for (List<Integer> l : subsets_dp(nums, ed - 1)) {
				List<Integer> new_l = new ArrayList<>(l);
				new_l.add(end);
				r.add(new_l);
				r.add(l);
			}
		} else {
			r.add(new ArrayList<Integer>());
		}
		return r;
	}
}
