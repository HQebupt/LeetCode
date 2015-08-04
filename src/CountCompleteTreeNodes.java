public class CountCompleteTreeNodes {
	// Solution 1: 递归超时
	// Time:O(n) Space:O(n) 超时
	public int countNodes0(TreeNode root) {
		if (root == null)
			return 0;
		return countNodes(root.left) + 1 + countNodes(root.right);
	}

	// Solution2: 改进版，减少用递归的次数
	// Time:O(log N) Space:O(logN)
	// ` (2 << leftHigh) - 1`才不会超时，用`Math.pow()`超时
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int leftHigh = 0, rightHigh = 0;
		TreeNode lchild = root.left, rchild = root.right;
		for (; lchild != null;) {
			leftHigh++;
			lchild = lchild.left;
		}
		for (; rchild != null;) {
			rightHigh++;
			rchild = rchild.right;
		}

		if (leftHigh == rightHigh) {
			return (2 << leftHigh) - 1;
		} else {
			return countNodes(root.left) + 1 + countNodes(root.right);
		}
	}
	// Solution 3: 二分查找，这个思想应该是最优解。

	public static void main(String[] args) {
		CountCompleteTreeNodes sol = new CountCompleteTreeNodes();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		System.out.println(sol.countNodes(t1));
	}
}