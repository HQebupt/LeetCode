public class SymmetricTree {
	// DFS:先序遍历
	// Time:　O(n)  Space: O(logn) 空间复杂度的产生是由于DFS的递归压栈而造成的
	public boolean isSymmetric(TreeNode root) {
		return root == null ? true : isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode l, TreeNode r) {
		// 终止条件
		if (l == null && r == null)
			return true;
		// 剪枝
		if (l == null || r == null)
			return false;
		return l.val == r.val && isSymmetric(l.left, r.right)
				&& isSymmetric(l.right, r.left);
	}
}
