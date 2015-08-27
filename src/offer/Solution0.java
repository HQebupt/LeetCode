package offer;

import java.util.LinkedList;

public class Solution0 {
	/**
	 * DFS 寻找二叉树中是否有相应的节点，找到就返回一条路径。
	 */
	boolean dfs(TreeNode root, TreeNode goal, LinkedList<TreeNode> cur) {
		if (root == null)
			return false;
		if (root == goal) {
			cur.add(root);
			return true;
		}

		cur.add(root);
		if (dfs(root.left, goal, cur))
			return true;
		if (dfs(root.right, goal, cur))
			return true;
		cur.removeLast();
		return false;
	}

	public static void main(String[] args) {
		Solution0 sol = new Solution0();
		TreeNode t0 = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t0.left = t1;
		t0.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t5.right = t6;
//		t6.left = t7;
		LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
		sol.dfs(t0, t7, cur);
		System.out.println(cur);
	}

}
