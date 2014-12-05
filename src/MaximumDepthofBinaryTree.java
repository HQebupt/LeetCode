// Time:O(logn) Space:O(logn)
public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.setRight(t2);
		t2.setLeft(t3);
		System.out.println(new MaximumDepthofBinaryTree().maxDepth(t1));
	}
}