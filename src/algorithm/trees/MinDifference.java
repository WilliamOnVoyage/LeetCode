package algorithm.trees;

public class MinDifference {
	int minDiff = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return minDiff;
	}

	private void helper(TreeNode curr, int lb, int rb) {
		if (curr == null)
			return;
		if (lb != Integer.MIN_VALUE) {
			minDiff = Math.min(minDiff, curr.val - lb);
		}
		if (rb != Integer.MAX_VALUE) {
			minDiff = Math.min(minDiff, rb - curr.val);
		}
		helper(curr.left, lb, curr.val);
		helper(curr.right, curr.val, rb);
	}
}
