package algorithm.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
	private TreeNode temp_end;

	public Codec() {
		q = new LinkedList<TreeNode>();
		end = null;
		temp_end = null;
	}

	public String serialize(TreeNode root) {
		end = root;
		temp_end = root;
		q.add(root);
		String s = serialize_node();
		if (s.charAt(0) == ',')
			s = "[" + s.substring(1) + "]";// remove the initial comma and add
											// []
		System.out.println(s);
		return s;
	}

	private String serialize_node() {
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			sb.append(",");
			if (node == null) {
				sb.append("null");
			} else {
				temp_end = node.right == null ? (node.left == null ? temp_end : node.left) : node.right;
				sb.append(Integer.toString(node.val));
				if (node == end) {
					if (temp_end == end)
						break;
					end = temp_end;
				}
				q.add(node.left);
				q.add(node.right);
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() < 2)
			return null;// at least "[]"
		String s = data.substring(1, data.length() - 1); // Remove []
		return construct_tree_from_String(s);
	}

	private TreeNode construct_tree_from_String(String s) {
		String[] nodes = s.split(",");
		TreeNode head = null;
		if (nodes.length > 0) {
			TreeNode dummy_head = new TreeNode(-1);
			List<TreeNode> p_level = new ArrayList<>();
			List<TreeNode> c_level = new ArrayList<>();
			p_level.add(dummy_head);

			for (int i = 0, end_index = 0; i < nodes.length; i++) {
				TreeNode node;
				if (nodes[i].equals("null")) {
					node = null;
				} else {
					node = new TreeNode(Integer.valueOf(nodes[i]));
				}
				c_level.add(node);
				if (i == end_index || i == nodes.length - 1) {
					for (int j = 0; j < p_level.size(); j++) {
						if (j * 2 < c_level.size())
							p_level.get(j).left = c_level.get(j * 2);
						if (j * 2 + 1 < c_level.size())
							p_level.get(j).right = c_level.get(j * 2 + 1);
					}
					c_level.removeAll(Collections.singleton(null));
					end_index += 2 * c_level.size();
					System.out.println("End index: " + end_index + " Parent size: " + p_level.size());
					p_level = new ArrayList<>(c_level);
					c_level = new ArrayList<>();
				}
			}
			head = dummy_head.left;
		}
		return head;
	}

}
