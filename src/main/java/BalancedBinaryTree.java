public class BalancedBinaryTree {
	// DFS
	// Time: O(n) Space: O(logn)
	public boolean isBalanced(TreeNode root) {
		return balancedHeight(root) >= 0;
	}

	// isBalanced return height of tree, Otherwise return -1.
	private int balancedHeight(TreeNode root) {
		// 终止
		if (root == null) return 0;
		int left = balancedHeight(root.left);
		int right = balancedHeight(root.right);
		// 剪枝
		if (left < 0 || right < 0 || Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		BalancedBinaryTree sol = new BalancedBinaryTree();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(2);
		TreeNode t6 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		System.out.println(sol.isBalanced(t1));
	}
}
