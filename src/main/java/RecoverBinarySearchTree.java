
public class RecoverBinarySearchTree {
	TreeNode pre;
	TreeNode first;
	TreeNode second;
	// inOrder 
	// Time:O(n)  Space:O(logn)
	public void recoverTree(TreeNode root) {
		inorderRecursion(root);
		if (first != null && second != null) {
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}
	}

	private void inorderRecursion(TreeNode root) {
		if (root == null)
			return;
		inorderRecursion(root.left);
		if (pre == null) {
			pre = root;
		} else {
			if (pre.val > root.val) {
				if (first == null)
					first = pre;
				second = root;
			}
			pre = root;
		}
		inorderRecursion(root.right);
	}
	
	public static void main(String[] args) {
		RecoverBinarySearchTree sol = new RecoverBinarySearchTree();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t3.left = t1;
		t3.right = t4;
		t4.left = t2;
		t4.right = t5;
		sol.recoverTree(t3);
		System.out.println(t3.rightString());
	}
}
