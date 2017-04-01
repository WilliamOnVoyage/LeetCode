package algorithm.trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithm.trees.TreeNode;

public class PreOrderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> r = new ArrayList<>();
		TreeNode n = root;
		Stack<TreeNode> s = new Stack<>();
		while (n != null || !s.isEmpty()) {
			if (n != null) {
				r.add(n.val);
				s.push(n);
				n = n.left;
			} else {
				n = s.pop().right;
			}
		}
		return r;
	}
}
