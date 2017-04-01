package algorithm.trees.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithm.trees.TreeNode;

public class ButtomUpLevelOrderTraversal {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> r = new ArrayList<>();
		if (root == null)
			return r;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int level = q.size();
			List<Integer> cur = new ArrayList<>();
			for (int i = 0; i < level; i++) {
				if (q.peek().left != null)
					q.add(q.peek().left);
				if (q.peek().right != null)
					q.add(q.peek().right);
				cur.add(q.poll().val);
			}
			r.add(cur);
		}
		Collections.reverse(r);
		return r;
	}
}
