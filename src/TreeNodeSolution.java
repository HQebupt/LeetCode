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
public class TreeNodeSolution {
	// 递归4种遍历
	public List<Integer> preorderRecursion(TreeNode root) {
		List<Integer> preOrder = new ArrayList<Integer>();
		if ((root != null) && (root.val != '#')) {
			preOrder.add(root.val);
			postorderRecursion(root.left);
			postorderRecursion(root.right);
		}
		return preOrder;
	}

	public List<Integer> inorderRecursion(TreeNode root) {
		List<Integer> inOrder = new ArrayList<Integer>();
		if ((root != null) && (root.val != '#')) {
			postorderRecursion(root.left);
			inOrder.add(root.val);
			postorderRecursion(root.right);
		}
		return inOrder;
	}

	public List<Integer> postorderRecursion(TreeNode root) {
		List<Integer> postOrder = new ArrayList<Integer>();
		if ((root != null) && (root.val != '#')) {
			postorderRecursion(root.left);
			postorderRecursion(root.right);
			postOrder.add(root.val);
		}
		return postOrder;
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		traverse(root, 1, res);
		return res;
	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		traverse(root, 1, res);
		int size = res.size();
		ArrayList<ArrayList<Integer>> resReverse = new ArrayList<ArrayList<Integer>>();
		for (int i = size - 1; i >= 0; i--) {
			resReverse.add(res.get(i));
		}
		return resReverse;
	}

	private void traverse(TreeNode root, int level,
			ArrayList<ArrayList<Integer>> res) {
		if (root == null)
			return;
		int size = res.size();
		if (level > size) {
			res.add(new ArrayList<Integer>());
		}
		res.get(level - 1).add(root.val);
		traverse(root.left, level + 1, res);
		traverse(root.right, level + 1, res);
	}

	// 3种遍历的迭代实现
	public List<Integer> inorderTraversal(TreeNode p) {
		List<Integer> inOrder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while ((p != null) || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				inOrder.add(p.val);
				p = p.right;
			}
		}
		return inOrder;
	}

	public List<Integer> preorderTraversal(TreeNode p) {
		List<Integer> preOrder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while ((p != null) || !stack.isEmpty()) {
			if (p != null) {
				preOrder.add(p.val);
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				p = p.right;
			}
		}
		return preOrder;
	}

	public List<Integer> postorderTraversal(TreeNode p) {
		List<Integer> postOrder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> tag = new Stack<Boolean>();
		while ((p != null) || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				tag.push(false);
				p = p.left;
			} else {
				boolean visit = tag.pop();
				if (visit) {
					postOrder.add(stack.pop().val);
				} else {
					tag.push(true);
					p = stack.peek().right;
				}
			}
		}
		return postOrder;
	}

	// main method.
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.setRight(t2);
		t1.setLeft(t3);
		System.out.println(new TreeNodeSolution().postorderTraversal(t1));
	}
}