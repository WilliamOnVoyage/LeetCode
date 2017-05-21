package algorithm;

import java.util.*;

public class MissingRange {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<String>();
		long low = (long) lower;
		long high = (long) lower;

		for (int i = 0; i <= nums.length; i++) { // i<=nums.length can add last
													// missing range
			low = i == 0 ? low : (long) nums[i - 1] + 1;
			high = i == nums.length ? (long) upper : (long) nums[i] - 1;

			if (low == high)
				res.add(low + "");
			if (low < high)
				res.add(low + "->" + high);
		}
		return res;
	}
}
