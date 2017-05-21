package algorithm.recursionDP;

import java.util.*;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> r = new ArrayList<>();
		combinationSum_dp(candidates, 0, target, new ArrayList<>(), r);
		return r;
	}

	public void combinationSum_dp(int[] nums, int st, int target, List<Integer> line, List<List<Integer>> r) {
		if (target == 0) {
			r.add(new ArrayList<>(line));
			return;
		}
		if (target < nums[st])
			return;

		for (int i = st; i < nums.length; i++) {
			if (i > st && nums[i] == nums[i - 1])
				continue;
			line.add(nums[i]);
			combinationSum_dp(nums, i, target - nums[i], line, r);
			line.remove(line.size() - 1);
		}
	}
}
