public class SameTree {
	// DFS:先序遍历
	// Time:　O(n)  Space: O(logn) 空间复杂度的产生是由于DFS的递归压栈而造成的
	public boolean isSameTree(TreeNode t1, TreeNode t2) {
		// 终止条件
		if (t1 == null && t2 == null)
			return true;
		// 剪枝
		if (t1 == null || t2 == null)
			return false;
		return t1.val == t2.val && isSameTree(t1.left, t2.left)
				&& isSameTree(t1.right, t2.right);
	}

}
