package offer;

public class Solution48 {
	/**
	 * 求二叉树的深度
	 * 递归和非递归的解法，时间和空间复杂度一样。
	 * Time:O(n)  Space:O(logn)
	 */
	public int TreeDepth(TreeNode root) {
        if (root == null){
        	return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
