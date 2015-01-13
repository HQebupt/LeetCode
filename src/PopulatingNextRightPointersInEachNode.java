
public class PopulatingNextRightPointersInEachNode {
	// 递归，为什么空间复杂度是常数
	// 因为递归是在最后调用的，没有压栈存储中间结果。本质是该递归没有返回值。
	// Time:O(n)  Space:O(1)
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode dummy = new TreeLinkNode(-1);
		for (TreeLinkNode curr = root, prev = dummy; curr != null; curr = curr.next) {
			if (curr.left != null) {
				prev.next = curr.left;
				prev = prev.next;
			}
			if (curr.right != null) {
				prev.next = curr.right;
				prev = prev.next;
			}
		}
		connect(dummy.next);
	}

}
