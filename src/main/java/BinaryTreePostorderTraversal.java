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
public class BinaryTreePostorderTraversal {
   public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode p = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<Boolean> tag = new Stack<Boolean>();
		while (p != null || (!s.isEmpty())) {
			if (p != null) {
				s.push(p);
				tag.push(false);
				p = p.left;
			} else {
				boolean visit = tag.pop();
				if (visit) {
					res.add(s.pop().val);
				} else {
					tag.push(true);
					p = s.peek().right;
				}
			}
		}
		return res;
	}
   
   public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.right = t2;
		t2.left = t3;
		BinaryTreePostorderTraversal sol = new BinaryTreePostorderTraversal();
		ArrayList<Integer> res  = (ArrayList<Integer>) sol.postorderTraversal(t1);
		System.out.println(res);
	}
}
/**
 * Solution report:http://www.cnblogs.com/byrhuangqiang/p/3790857.html
 */ 