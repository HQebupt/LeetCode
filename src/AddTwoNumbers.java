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
//时间复杂度：O(max<m,n>) 空间复杂度O(1)
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		dummy.next = null;
		ListNode tail = dummy;
		for (ListNode p1 = l1, p2 = l2; p1 != null || p2 != null;) {
			int a1 = p1 == null ? 0 : p1.val;
			int a2 = p2 == null ? 0 : p2.val;
			int sum = dummy.val + a1 + a2;
			dummy.val = sum < 10 ? 0 : 1;
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
			p1 = p1 == null ? null : p1.next;
			p2 = p2 == null ? null : p2.next;
		}
		if (dummy.val == 1)
			tail.next = new ListNode(1);
		return dummy.next;
	}

	public static void main(String[] args) {
		AddTwoNumbers sol = new AddTwoNumbers();
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		a1.next = a2;
		a2.next = a3;
		b1.next = b2;
		b2.next = b3;
		ListNode res = sol.addTwoNumbers(a1, b1);
		System.out.println(res);
	}
}