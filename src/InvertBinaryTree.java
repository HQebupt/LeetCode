public class InvertBinaryTree {
	// ˼·1��2�ǵݹ��˼·
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
	// ��˼·1һ�����ӿڲ�ͬ���ѡ�
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

	// Solution 3���ǵݹ��ʵ��
	// Todo
}