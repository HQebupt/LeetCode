import java.util.Deque;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {
	// 递归，为什么空间复杂度是常数
	// 因为递归是在最后调用的，没有压栈存储中间结果。本质是该递归没有返回值。
	// Time:O(n) Space:O(1)
	public void connect0(TreeLinkNode root) {
		if (root == null)
			return;
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
		connect0(dummy.next);
	}

	// BFS解题
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Deque<TreeLinkNode> dq = new LinkedList<TreeLinkNode>();
		dq.add(root);
		int curCount = 1, nextCount = 0;
		TreeLinkNode preNode = null;
		while (!dq.isEmpty()) {
			TreeLinkNode curNode = dq.removeFirst();
			curCount--;
			if (curNode.left != null) {
				nextCount++;
				dq.add(curNode.left);
			}
			if (curNode.right != null) {
				nextCount++;
				dq.add(curNode.right);
			}

			if (preNode == null) {
				preNode = curNode;
			} else {
				preNode.next = curNode;
				preNode = curNode;
			}

			if (curCount == 0) {
				preNode = null;
				curCount = nextCount;
				nextCount = 0;
			}
		}
	}

}
