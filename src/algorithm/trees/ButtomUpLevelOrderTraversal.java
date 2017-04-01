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
	// More concise level order traversal using DFS & BFS
	// DFS:
	// public List<List<Integer>> levelOrderBottom(TreeNode root) {
	// Queue<TreeNode> queue = new LinkedList<TreeNode>();
	// List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
	//
	// if(root == null) return wrapList;
	//
	// queue.offer(root);
	// while(!queue.isEmpty()){
	// int levelNum = queue.size();
	// List<Integer> subList = new LinkedList<Integer>();
	// for(int i=0; i<levelNum; i++) {
	// if(queue.peek().left != null) queue.offer(queue.peek().left);
	// if(queue.peek().right != null) queue.offer(queue.peek().right);
	// subList.add(queue.poll().val);
	// }
	// wrapList.add(0, subList);
	// }
	// return wrapList;
	// }
	
	// BFS:
	// public List<List<Integer>> levelOrderBottom(TreeNode root) {
	// List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
	// levelMaker(wrapList, root, 0);
	// return wrapList;
	// }
	//
	// public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
	// if(root == null) return;
	// if(level >= list.size()) {
	// list.add(0, new LinkedList<Integer>());
	// }
	// levelMaker(list, root.left, level+1);
	// levelMaker(list, root.right, level+1);
	// list.get(list.size()-level-1).add(root.val);
	// }
}
