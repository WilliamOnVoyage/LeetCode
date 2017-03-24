package algorithm.trees;

public class LCA {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		// For binary tree
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null || root == p || root == q)
				return root;
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			return left == null ? right : right == null ? left : root;
		}

		// For BST
		// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
		// TreeNode q) {
		// while ((root.val - p.val) * (root.val - q.val) > 0)
		// root = p.val < root.val ? root.left : root.right;
		// return root;
		// }
	}
}
