//时间复杂度：0（n) 空间复杂度：O（logn）
public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxPathBranch(root);
		return max;
	}

	public int maxPathBranch(TreeNode root) {
		if (root == null)
			return 0;
		int l = maxPathBranch(root.left);
		int r = maxPathBranch(root.right);
		int sum = root.val;
		if (l > 0)
			sum += l;
		if (r > 0)
			sum += r;
		max = max < sum ? sum : max;
		int lrMax = l > r ? l : r;
		return lrMax > 0 ? lrMax + root.val : root.val;
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
		TreeNode t1 = new TreeNode(-1);
		TreeNode t2 = new TreeNode(-2);
		TreeNode t3 = new TreeNode(-6);
		TreeNode t4 = new TreeNode(-1);
		t1.setLeft(t2);
		t1.setRight(t3);
		t2.setLeft(t4);
		System.out.println(sol.maxPathSum(t1));

	}
}