import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BinaryTreePreorderTraversal {
	List<Integer> preorder = new ArrayList<Integer>();
	Stack<TreeNode> stack = new Stack<TreeNode>();

	//Sol 1. Time:O(n) Space:O(n)
	public List<Integer> preorderTraversal1(TreeNode root) {
		TreeNode p = root;
		while (p != null || (!stack.isEmpty())) {
			if (p != null) {
				preorder.add(p.val);
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				p = p.right;
			}
		}
		return preorder;
	}
	//Sol 2. Time:O(n) Space:O(n)
	public List<Integer> preorderTraversal2(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root != null) {
			s.push(root);
		}
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			res.add(node.val);
			if (node.right != null)
				s.push(node.right);
			if (node.left != null)
				s.push(node.left);
		}
		return res;
	}
}
/**
 * solution report:http://www.cnblogs.com/byrhuangqiang/p/3790857.html the
 * blog's end part content.
 */
