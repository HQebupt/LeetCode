package offer;

/**
 * 重建二叉树：先序+中序；扩展--先序+后序
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,
 * 5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并输出它的后序遍历序列。
 * 
 * @date 2015-7-14
 */
public class Solution7 {
	// 参考leetcode ConstructBinaryTreefromPreorderandInorderTraversal
	// Time:O(n * logn)  Space:O(logn)
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return buildTreeHelp(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private TreeNode buildTreeHelp(int[] preorder, int pres, int pree,
			int[] inorder, int instart, int inend) {

		// 剪枝
		if (pres > pree || instart > inend)
			return null;

		int val = preorder[pres];
		TreeNode root = new TreeNode(val);

		int iroot = 0;
		for (int i = instart; i <= inend; i++) {
			if (inorder[i] == val) {
				iroot = i;
				break;
			}
		}
		int count = iroot - instart;
		root.left = buildTreeHelp(preorder, pres + 1, pres + count, inorder,
				instart, iroot - 1);
		root.right = buildTreeHelp(preorder, pres + count + 1, pree, inorder,
				iroot + 1, inend);
		return root;
	}

	public static void main(String[] args) {
		Solution7 sol = new Solution7();
		int[] preorder = { 1, 2, 4, 5, 3, 6, 8, 7 };
		int[] inorder = { 4, 2, 5, 1, 6, 8, 3, 7 };
		System.out.println(sol.reConstructBinaryTree(preorder, inorder)
				.rightString());
	}
}
