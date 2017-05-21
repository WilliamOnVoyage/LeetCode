
package algorithm.sortAndsearh;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			while (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
				swap(nums, i, nums[i] - 1);
			}
			i++;
		}
		i = 0;
		while (i < nums.length && nums[i] == i + 1)
			i++;
		return i + 1;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}