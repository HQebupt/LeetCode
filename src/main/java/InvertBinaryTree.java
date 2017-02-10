public class InvertBinaryTree {
	// 思路1和2是递归的思路
	// Solution 1: Time O(n); Space O(n)
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		TreeNode tmp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tmp);
		return root;
	}

	// Solution 2: Time O(n); Space O(n)
	// 和思路1一样，接口不同而已。
	public void invertTree2(TreeNode root) {
		if (root == null)
			return;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		if (root.left != null)
			invertTree2(root.left);
		if (root.right != null)
			invertTree2(root.right);
	}

	// Solution 3：非递归的实现
	// Todo
}