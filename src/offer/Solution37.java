package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution37 {
	/**
	 * 两个指针的应用
	 * Time: O(m + n) Space: O(1)
	 * @param head1 链表1
	 * @param head2 链表2
	 * @return 第一个公共节点
	 */
	public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
		// 1.求链表长度
		int len1 = 0, len2 = 0;
		ListNode p1 = head1, p2 = head2;
		for (; p1 != null; p1 = p1.next) {
			len1++;
		}
		for (; p2 != null; p2 = p2.next) {
			len2++;
		}

		// 2.找出长短链表，让长链表先走diff步数
		ListNode fast, slow;
		int diff = Math.abs(len2 - len1);
		if (len1 > len2) {
			fast = head1;
			slow = head2;
		} else {
			fast = head2;
			slow = head1;
		}

		for (; diff > 0; diff--) {
			fast = fast.next;
		}
		// 3.长短链表以相同的速度前进，遇到第一个相同的节点，就是公共节点。
		for (; fast != null && (slow != null); fast = fast.next, slow = slow.next) {
			if (fast == slow)
				return fast;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Solution37 sol = new Solution37();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l6;
		l6.next = l7;
		l4.next = l5;
		l5.next = l6;
		System.out.println(sol.findFirstCommonNode(l1, l4));
		List<TreeNode> dq = new LinkedList<TreeNode>();
		dq.
	}
}
