public class MinimumDepthofBinaryTree {
	// 递归, 靠辅助变量hasBrother
	// Time: O(n)  Space: O(logn)
	public int minDepth(TreeNode root) {
		return minDepth(root, false);
	}
	
    private int minDepth(TreeNode root, boolean hasBrother) {
        if (root == null) 
        	return hasBrother ? Integer.MAX_VALUE : 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return Math.min(minDepth(left, right != null), minDepth(right, left != null)) + 1;
    }
	
}