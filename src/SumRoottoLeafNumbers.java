public class SumRoottoLeafNumbers {
	// DFS
	// Time: O(n)  Space: O(logn)
	public int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	// 辅助方法
	private int dfs(TreeNode root, int sum) {
		// 剪枝
		if (root == null) return 0; 
		
		// 终止条件
		if (root.left == null && root.right == null) return sum * 10 + root.val; 

		return dfs(root.left, sum * 10 + root.val)
				+ dfs(root.right, sum * 10 + root.val);
	}
}