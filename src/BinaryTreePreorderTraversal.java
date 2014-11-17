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
public class BinaryTreePreorderTraversal {
    List<Integer> preorder = new ArrayList<Integer>();
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public List<Integer> preorderTraversal(TreeNode root) {
		TreeNode p = root;
		while (p != null || (!stack.isEmpty())) {
			if(p!=null){
				preorder.add(p.val);
				stack.push(p);
				p = p.left;
			}else{
				p = stack.pop();
				p = p.right;
			}
		}
		return preorder;
	}
}
/**
 * solution report:http://www.cnblogs.com/byrhuangqiang/p/3790857.html
 * the blog's end part content.
 */ 