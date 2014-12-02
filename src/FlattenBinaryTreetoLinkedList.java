/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class FlattenBinaryTreetoLinkedList {
	// Sol 1:递归  Time:O(n) Space:O(logn)
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			TreeNode tmp = root.right;
			root.right = root.left;
			TreeNode p = root.right;
			while (p.right != null) {
				p = p.right;
			}
			p.right = tmp;
			root.left = null;
		}
		flatten(root.right);
	}

	// Sol 2：非递归 Time:O(n) Space:O(logn)
	public void flattenTraversal(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode tmp = root.right;
				root.right = root.left;
				TreeNode p = root.right;
				while (p.right != null) {
					p = p.right;
				}
				p.right = tmp;
				root.left = null;
			}
			root = root.right;
		}
	}

	// main method.
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.setLeft(t2);
		t1.setRight(t5);
		t2.left = t3;
		t2.right = t4;
		t5.right = t6;
		FlattenBinaryTreetoLinkedList sol = new FlattenBinaryTreetoLinkedList();
		sol.flattenTraversal(t1);
		System.out.println(t1.rightString());
	}
}