package algorithm.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trie {
	class TreeNode {
		String val;
		List<TreeNode> next; // This can be set as TreeNode[26] for tries only
								// containing a-z

		TreeNode(String x) {
			val = x;
			next = new ArrayList<>();
		}
	}

	Set<String> set;
	TreeNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TreeNode("");
		set = new HashSet<String>();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		for (int i = word.length(); i >= 0; i--) {
			String prefix = word.substring(0, i);
			TreeNode n = search_node(root, prefix);
			if (n != null && !set.contains(word)) {
				TreeNode new_node = new TreeNode(word);
				set.add(word);
				n.next.add(new_node);
				break;
			}
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return set.contains(word);
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		return search_prefix(root, prefix) != null;
	}

	private TreeNode search_node(TreeNode node, String word) {
		if (node == null || !word.contains(node.val))
			return null;
		if (node.val.equals(word))
			return node;
		else {
			TreeNode t = null;
			for (TreeNode n : node.next) {
				t = search_node(n, word);
				if (t != null)
					break;
			}
			return t;
		}
	}

	private TreeNode search_prefix(TreeNode node, String prefix) {
		if (node == null)
			return null;
		if (node.val.contains(prefix))
			return node;
		else {
			TreeNode t = null;
			for (TreeNode n : node.next) {
				t = search_prefix(n, prefix);
				if (t != null)
					break;
			}
			return t;
		}
	}
}
