/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//时间复杂度：0(n) 空间复杂度O(1)
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}
		// 就地反转法
		ListNode dummy2 = prev;
		prev = dummy2.next;
		ListNode pCur = prev.next;
		for (int i = m - 1; i < n - 1; i++) {
			prev.next = pCur.next;
			pCur.next = dummy2.next;
			dummy2.next = pCur;
			pCur = prev.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		ReverseLinkedListII sol = new ReverseLinkedListII();
		ListNode r1 = sol.reverseBetween(n1, 1, 3);
		System.out.println("ok");
		while (r1 != null) {
			System.out.println(r1.val);
			r1 = r1.next;
		}
	}
}