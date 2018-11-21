import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time:O(n) Space:O(n)
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode p = root;
       	if (p != null) {
       	    s.push(p);
        }
        while(!s.isEmpty()) {
            if (p == null || p.left == null) {
                p = s.pop();
                res.add(p.val);
                if (p.right != null) {
                    s.push(p.right);
                    p = p.right;
                } else {
                    p = null;
                }
            } else if(p.left != null) {
                s.push(p.left);
                p = p.left;
            }
        }
        return res;
    }
}