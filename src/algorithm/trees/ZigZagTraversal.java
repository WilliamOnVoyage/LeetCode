package algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {
	public class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int x) {
			val = x;
		}
	}

	private List<List<Integer>> r;

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		r = new ArrayList<>();
		if (root == null)
			return r;

		zigzag(root);
		return r;
	}

	private void zigzag(TreeNode root) {
		TreeNode end = root;
		TreeNode temp_end = null;
		Queue<TreeNode> q = new LinkedList<>();
		Stack<TreeNode> s = new Stack<>();
		boolean forward = true;
		List<Integer> level = new ArrayList<>();
		
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			level.add(node.val);
			if (forward) {
				temp_end = temp_end == null ? (node.left == null ? node.right : node.left) : temp_end;
				if (node.left != null)
					s.push(node.left);
				if (node.right != null)
					s.push(node.right);
			} else {
				temp_end = temp_end == null ? (node.right == null ? node.left : node.right) : temp_end;
				if (node.right != null)
					s.push(node.right);
				if (node.left != null)
					s.push(node.left);
			}
			if (node == end) {
				r.add(level);
				level = new ArrayList<>();
				end = temp_end;
				temp_end = null;
				forward = !forward;
				pour(s, q);
			}
		}
	}

	private void pour(Stack<TreeNode> s, Queue<TreeNode> q) {
		while (!s.isEmpty()) {
			q.add(s.pop());
		}
	}
}
