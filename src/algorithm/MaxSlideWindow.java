package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlideWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[0];
		if (k > 0 && nums != null) {
			result = new int[nums.length + 1 - k];
			Deque<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < nums.length; i++) {
				while (!q.isEmpty() && q.peekFirst() < i + 1 - k)
					q.poll();
				while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
					q.pollLast();
				q.offerLast(i);
				if (i >= k - 1)
					result[i + 1 - k] = nums[q.peekFirst()];
			}
		}
		return result;
	}
}
