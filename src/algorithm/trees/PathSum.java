package algorithm.trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		addSum(root, sum, result, temp);
		return result;
	}

	private void addSum(TreeNode node, int sum, List<List<Integer>> result, List<Integer> temp) {
		if (node == null)
			return;
		temp.add(node.val);
		if (node.left == null && node.right == null && sum == node.val) {
			result.add(new ArrayList<>(temp));
		} else {
			addSum(node.left, sum - node.val, result, temp);
			addSum(node.right, sum - node.val, result, temp);
		}
		temp.remove(temp.size() - 1);
	}
}
