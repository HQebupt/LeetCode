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
        while (p != null || !s.isEmpty()) {
        	if (p != null) {
        		s.push(p);
        		p = p.left;
        	}else{
        		p = s.pop();
        		res.add(p.val);
        		p = p.right;
        	}
        }
        return res;
    }
}