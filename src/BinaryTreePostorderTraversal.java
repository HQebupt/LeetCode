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
public class BinaryTreePostorderTraversal {
   public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postorder = new ArrayList<Integer>();
		TreeNode p = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> tag = new Stack<Boolean>();
		while (p != null || (!stack.isEmpty())) {
			if (p != null) {
				stack.push(p);
				tag.push(false);
				p = p.left;
			} else {
				boolean visit = tag.pop();
				if (visit) {
					postorder.add(stack.pop().val);
				} else {
					tag.push(true);
					p = stack.peek().right;
				}
			}
		}
		return postorder;
	}
}
/**
 * Solution report:http://www.cnblogs.com/byrhuangqiang/p/3790857.html
 */ 