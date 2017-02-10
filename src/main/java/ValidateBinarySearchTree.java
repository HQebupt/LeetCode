public class ValidateBinarySearchTree {
	// Solution 1: BST的定义
	// Time:O(n)  Space(logn)
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	/**
	 * root节点是否是BST
	 * @param root 节点root
	 * @param lower 节点root成为BST的下界
	 * @param upper 节点root成为BST的上界
	 * @return is BST or not
	 * Integer.MIN_VALUE, Integer.MAX_VALUE 不能够AC了，必须用Long
	 */
	private boolean isValidBST(TreeNode root, long lower, long upper) {
		if (root == null) return true;
		return root.val > lower &&
			root.val < upper &&
			isValidBST(root.left, lower, root.val) &&
			isValidBST(root.right, root.val, upper);
	}
	
	
	// Solution 2: BST树的性质,中序遍历递增。
	// 采用一个变量保存前驱,中序遍历.
	// AC 不了，由于全局变量的缘故。
	// Time:O(n)  Space:O(logn)
	private static int prev = Integer.MIN_VALUE; 
	public boolean isValidBST2(TreeNode root) {
		if (root == null) 
			return true;
		if(isValidBST2(root.left) == false) 
			return false;
		if (prev >= root.val)
			return false;	
		prev = root.val;
		if (isValidBST2(root.right) == false)
			return false;
		return true;
	}
}