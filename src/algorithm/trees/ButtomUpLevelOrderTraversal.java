package algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ButtomUpLevelOrderTraversal {
	class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int x) {
			val = x;
		}
	}

	Queue<TreeNode> q;
	TreeNode end;
	TreeNode temp_end;
	List<List<Integer>> r;
	Stack<List<Integer>> s;

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		s = new Stack<>();
		r = new ArrayList<>();
		if (root == null)
			return r;
		q = new LinkedList<>();
		end = root;
		temp_end = root.right == null ? root.left : root.right;
		q.add(root);
		LOT();
		while (!s.isEmpty()) {
			r.add(s.pop());
		}
		return r;
	}

	private void LOT() {
		List<Integer> level = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			level.add(node.val);
			temp_end = node.right == null ? (node.left == null ? temp_end : node.left) : node.right;
			if (node == end) {
				s.push(level);
				level = new ArrayList<>();
				end = temp_end;
			}
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
	}
}
