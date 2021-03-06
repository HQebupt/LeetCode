public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}

	public String toString() {
		return "" + val;
	}

	public String rightString() {
		String r = "" + val;
		while (right != null) {
			r += "-" + right.val;
			right = right.right;
		}
		return r;
	}

}
