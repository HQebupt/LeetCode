import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
public class BinaryTreeLevelOrderTraversal {
	// Solution 1： 从上往下层序遍历的递归做法
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		traverse(root, 1, res);
		return res;
	}
	
	// 从下往上的层序解法：把`从上往下遍历`的结果反转一下就ok了。
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		traverse(root, 1, res);
		int size = res.size();
		ArrayList<ArrayList<Integer>> resReverse = new ArrayList<ArrayList<Integer>>();
		for(int i = size - 1; i >= 0; i--) {
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
	
	// Solution 2: 宽度优先搜索
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		List<Integer> tmp = new ArrayList<Integer>();
		int lastNum = 1;
		int curNum = 0;
		if (root!=null) {
			deque.add(root);
		}
		
		while (!deque.isEmpty()) {
			root = deque.pop();
			lastNum--;
			tmp.add(root.val);
			
			if (root.left != null) {
				curNum++;
				deque.add(root.left);
			}
			if (root.right != null) {
				curNum++;
				deque.add(root.right);
			}
			
			if (lastNum == 0) {
				res.add(tmp);
				tmp = new ArrayList<Integer>();
				lastNum = curNum;
				curNum = 0;
			}
		}
	    return res;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> res = sol.levelOrder2(t1);
		System.out.println(res);
	}
}