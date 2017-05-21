package algorithm.recursionDP;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class HouseRobber {

	public int rob(int[] nums) {
		int robb = 0, unrobb = 0;
		for (int n : nums) {
			int prev = unrobb;
			unrobb = Math.max(robb, unrobb);
			robb = n + prev;
		}
		return Math.max(robb, unrobb);
	}

	public int rob(TreeNode root) {
		int[] result = DFS(root);
		return Math.max(result[0], result[1]);
	}

	private int[] DFS(TreeNode node) {
		if (node == null)
			return new int[] { 0, 0 };
		int[] left = DFS(node.left);
		int[] right = DFS(node.right);
		// if rob this node
		int unrobb = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		// if not rob this node
		int robb = node.val + left[1] + right[1];
		return new int[] { robb, unrobb };
	}
}
