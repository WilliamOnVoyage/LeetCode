package algorithm.trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithm.trees.TreeNode;

public class PostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> r = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode n = root;
		while (n != null || !s.isEmpty()) {
			if (n != null) {
				r.add(0, n.val);
				s.push(n);
				n = n.right;
			} else {
				n = s.pop().left;
			}
		}
		return r;
	}
}
