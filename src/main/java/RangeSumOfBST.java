/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class RangeSumOfBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return sum;
        }
        dfs(root, L, R);
        return sum;
    }

    private void dfs(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        if (root.val >= L && (root.val <= R)) {
            sum += root.val;
        }
        if (root.val > L) {
            dfs(root.left, L, R);
        }
        if (root.val < R) {
            dfs(root.right, L, R);
        }
    }
}