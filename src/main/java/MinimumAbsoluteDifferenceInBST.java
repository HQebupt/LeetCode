/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class MinimumAbsoluteDifferenceInBST {
    int minValue = Integer.MAX_VALUE;
    TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return minValue;
        }
        getMinimumDifference(root.left);
        if (preNode != null) {
            minValue = Math.min(minValue, root.val - preNode.val);
        }
        preNode = root;
        getMinimumDifference(root.right);
        return minValue;
    }
}