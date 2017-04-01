package algorithm.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {

	public int kthSmallest(TreeNode root, int k) {
		List<TreeNode> r = new ArrayList<>();
		InorderTraversal(root, r);
		return r.get(k - 1).val;
	}

	private void InorderTraversal(TreeNode node, List<TreeNode> list) {
		if (node == null)
			return;
		InorderTraversal(node.left, list);
		list.add(node);
		InorderTraversal(node.right, list);
	}

}
