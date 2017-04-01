package algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> r = new ArrayList<>();
		if (root == null)
			return r;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int level = q.size();
			for (int i = 0; i < level; i++) {
				if (q.peek().left != null)
					q.add(q.peek().left);
				if (q.peek().right != null)
					q.add(q.peek().right);
				if (i == level - 1)
					r.add(q.poll().val);
				else
					q.poll();
			}

		}
		return r;
	}
}
