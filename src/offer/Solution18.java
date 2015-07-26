package offer;
/**
 * 二叉树的镜像
 * 
 * 题目描述

操作给定的二叉树，将其变换为源二叉树的镜像。 
输入描述:
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
    	
 * @author HuangQiang
 * @date 2015-7-26下午09:47:37
 * @file Solution18.java
 */
public class Solution18 {
	/**
	 * 二叉树的镜像思路：交换每个Node的左右节点，递归直到交换完整棵树。
	 * Time：O(n) Space:O(1)
	 */
	public void mirror(TreeNode root) {
		if (root == null)
			return;
		TreeNode lroot = root.left;
		TreeNode rroot = root.right;
		root.left = rroot;
		root.right = lroot;
		mirror(root.left);
		mirror(root.right);
	}

	public static void main(String[] args) {
		Solution18 sol = new Solution18();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		sol.mirror(t1);
		System.out.println(t1.rightString());
	}
}
