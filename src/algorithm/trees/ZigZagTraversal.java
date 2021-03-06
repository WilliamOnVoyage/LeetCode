package algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal { // Use add at the head to append level with
								// zigzag
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> r = new ArrayList<>();
		if (root == null)
			return r;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean forward = true;
		while (!q.isEmpty()) {
			int level = q.size();
			List<Integer> cur = new ArrayList<>();
			for (int i = 0; i < level; i++) {
				if (q.peek().left != null)
					q.add(q.peek().left);
				if (q.peek().right != null)
					q.add(q.peek().right);
				if (forward)
					cur.add(q.poll().val);
				else
					cur.add(0, q.poll().val);
			}
			r.add(cur);
			forward = !forward;
		}
		return r;
	}
}
