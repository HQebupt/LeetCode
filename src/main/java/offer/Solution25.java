package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 二叉树中和为某一值的路径
 * 
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * 思路：leetcode Path Sum II
 * DFS思路，找出所有的解——4个参数，标准代码。
 * 
 * @date 2015-7-29上午11:55:59
 */
public class Solution25 {

	public List<ArrayList<Integer>> findPath(TreeNode root, int target) {
		List<ArrayList<Integer>> res = new LinkedList<ArrayList<Integer>>();
		LinkedList<Integer> cur = new LinkedList<Integer>();
		pathSum(root, target, cur, res);
		return res;
	}

	private void pathSum(TreeNode root, int gap, LinkedList<Integer> cur,
			List<ArrayList<Integer>> res) {
		if (root == null)
			return;
		cur.add(root.val);
		if ((root.left == null) && (root.right == null)) {
			if (gap == root.val) {
				res.add(new ArrayList<Integer>(cur));
			}
		} else {
			pathSum(root.left, gap - root.val, cur, res);
			pathSum(root.right, gap - root.val, cur, res);
		}
		cur.removeLast();
	}

	public static void main(String[] args) {
		Solution25 sol = new Solution25();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.setLeft(t2);
		t1.setRight(t3);
		t2.setLeft(t4);
		int sum = 4;
		System.out.println(sol.findPath(t1, sum));
	}

}
