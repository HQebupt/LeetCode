
public class KthSmallestElementinaBST {
	private int calNode(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + calNode(root.left) + calNode(root.right);
	}

	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return 0;
		int count = calNode(root.left);
		if (count == k - 1) {
			return root.val;
		}
		if (count > k - 1) {
			return kthSmallest(root.left, k);
		} else {
			return kthSmallest(root.right, k - count - 1);
		}
	}


	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t2.left = t1;
		t2.right = t3;
		TreeNode root = t2;
		int k = 2;
		KthSmallestElementinaBST sol = new KthSmallestElementinaBST();
		System.out.println(sol.kthSmallest(root, k));
	}
}