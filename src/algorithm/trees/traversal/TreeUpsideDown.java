
package algorithm.trees.traversal;

import algorithm.trees.TreeNode;

public class TreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode node) {
		if (node == null || (node.left == null && node.right == null))
			return node;
		TreeNode head = upsideDownBinaryTree(node.left);
		node.left.left = node.right;
		node.left.right = node;
		node.left = null;
		node.right = null;
		return head;
	}
}
