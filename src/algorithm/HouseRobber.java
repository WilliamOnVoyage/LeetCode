package algorithm;

import java.util.Arrays;

public class HouseRobber {
	private int[] loot;
	private int[] nums;

	public int rob(int[] nums) {

		if (nums.length < 1)
			return 0;
		this.nums = nums;
		loot = new int[nums.length];
		Arrays.fill(loot, -1);
		loot_max(0);
		return loot[0];
	}

	private int loot_max(int st) {
		if (st >= nums.length)
			return 0;
		if (st == nums.length - 1)
			loot[st] = nums[st];
		if (st == nums.length - 2) {
			loot[st] = Math.max(nums[st], nums[st + 1]);
		}
		if (loot[st] == -1)
			loot[st] = Math.max(nums[st] + loot_max(st + 2), nums[st + 1] + loot_max(st + 3));
		return loot[st];
	}
}
