package algorithm.trees;

public class BuildTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length)
			return null;
		return buildTree_recursive(preorder, inorder, 0, 0, inorder.length);
	}

	private TreeNode buildTree_recursive(int[] preorder, int[] inorder, int p_st, int i_st, int i_ed) {
		if (i_ed <= i_st)
			return null;
		TreeNode root = new TreeNode(preorder[p_st]);
		if (i_ed == i_st + 1)
			return root;

		int mid = i_st;
		for (int i = i_st; i < i_ed; i++) {
			if (inorder[i] == preorder[p_st]) {
				mid = i;
				break;
			}
		}
		root.left = buildTree_recursive(preorder, inorder, p_st + 1, i_st, mid);
		root.right = buildTree_recursive(preorder, inorder, p_st + mid + 1 - i_st, mid + 1, i_ed);
		return root;
	}
}
