/**
 * Time:O(n)
 * Space: O(logN)
 */

public class MinimumDistanceBetweenBSTNodes {
    int minVal = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        TreeNode p = root;
        if (p == null) {
            return minVal;
        }
        minDiffInBST(p.left);
        int current = p.val;
        minVal = minDiff(minVal, prev, current);
        prev = current;
        minDiffInBST(p.right);
        return minVal;
    }
    private int minDiff(int min, int prev, int current) {
        int tmp = prev > current ? prev - current : current - prev;
        return Math.min(min, tmp);
    }
}
