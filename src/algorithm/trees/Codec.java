package algorithm.trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Codec {
	private Queue<TreeNode> q;
	private TreeNode end;
	private TreeNode nextend;

	public Codec() {
		q = new LinkedList<TreeNode>();
		end = null;
		nextend = null;
	}

	public String serialize(TreeNode root) {
		end = root;
		String s = serialize_node(root);
		if (s.charAt(0) == ',')
			s = "[" + s.substring(1) + "]";// remove the extra comma and add []
		System.out.println(s);
		return s;
	}

	private String serialize_node(TreeNode node) {
		if (node == null)
			return ",null";
		StringBuilder result = new StringBuilder();
		if (node == end) {
			if (node.left != null || node.right != null) {
				end = node.right == null ? node.left : node.right;
				nextend = end;
			} else { // next end will remain the same, end = nextend
				end = nextend;
			}
		} else {
			nextend = node.right == null ? node.left : node.right;
		}

		result.append(',');
		result.append(node.val);
		q.add(node.left);
		q.add(node.right);
		if (end == null)
			return "";
		return result.toString() + serialize_node(q.poll());
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		TreeNode head = null;
		assert data.length() >= 2;// at least "[]"
		String s = data.substring(1, data.length() - 1);

		return head;
	}
}
