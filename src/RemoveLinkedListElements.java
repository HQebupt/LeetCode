/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		ListNode pCur = head;
		while (pCur != null) {
			if (pCur.val == val) {
				pCur = pCur.next;
				continue;
			}
			ListNode pNext = pCur.next;
			tail.next = pCur;
			tail = pCur;
			pCur = pNext;
		}
		tail.next = null;
		return dummy.next;
	}

	public static void main(String[] args) {
		RemoveLinkedListElements sol = new RemoveLinkedListElements();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		System.out.println(sol.removeElements(l1, 6));
	}
}