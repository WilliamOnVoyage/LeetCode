package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectBinaryTree {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	Queue<TreeLinkNode> q;
	TreeLinkNode end;
	TreeLinkNode temp_end;

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		q = new LinkedList<>();
		end = root;
		temp_end = root.right == null ? root.left : root.right;
		q.add(root);
		BFS();
	}

	private void BFS() {
		while (!q.isEmpty()) {
			TreeLinkNode node = q.poll();
			temp_end = node.right == null ? (node.left == null ? temp_end : node.left) : node.right;
			if (node == end) {
				node.next = null;
				end = temp_end;
			} else {
				node.next = q.peek();
			}
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
	}
}
