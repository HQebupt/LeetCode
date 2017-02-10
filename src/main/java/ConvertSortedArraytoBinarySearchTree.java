public class ConvertSortedArraytoBinarySearchTree {
	// 二分法
	// Time: O(n)  Space: O(logn)
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length - 1);
    }

	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (end - start < 0) return null;
		int mid = (end + start) >> 1;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
		return root;
	}
}