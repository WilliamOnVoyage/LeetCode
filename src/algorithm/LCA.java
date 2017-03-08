package algorithm;

import java.util.Stack;

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

		private Stack<TreeNode> sp;
		private Stack<TreeNode> sq;

		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root.val == p.val || root.val == q.val || p == null || q == null)
				return root;
			sp = new Stack<>();
			sq = new Stack<>();
			findp(root, p);
			findq(root, q);
			TreeNode t = root;
			while (sp.peek() == sq.peek()) {
				t = sp.pop();
				sq.pop();
				if (sp.isEmpty() || sq.isEmpty())
					break;
			}
			return t;
		}

		private boolean findp(TreeNode parent, TreeNode p) {
			if (parent == null)
				return false;
			if (parent.left.val == p.val || parent.right.val == p.val) {
				sp.push(parent);
				return true;
			}
			boolean found = findp(parent.left, p) || findp(parent.right, p);
			if (found)
				sp.push(parent);
			return found;
		}

		private boolean findq(TreeNode parent, TreeNode q) {
			if (parent == null)
				return false;
			if (parent.left.val == q.val || parent.right.val == q.val) {
				sq.push(parent);
				return true;
			}
			boolean found = findq(parent.left, q) || findq(parent.right, q);
			if (found)
				sq.push(parent);
			return found;
		}
		// For BST
		// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// while ((root.val - p.val) * (root.val - q.val) > 0)
		// root = p.val < root.val ? root.left : root.right;
		// return root;
		// }
	}
}
