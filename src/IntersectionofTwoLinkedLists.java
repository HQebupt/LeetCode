/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode fast, slow , aTail;
		if (headA == null)
			return null;
		fast = headA;
		while (fast.next != null) {
			fast = fast.next;
		}
		aTail = fast;// retain their original structure
		fast.next = headB;
		fast = headA;// build loop
		slow = headA;// two pointer
		boolean hasCycle = false;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				hasCycle = true;
				break;
			}
		}
		if (hasCycle) {
			fast = headA;
			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}
			aTail.next = null;// retain their original structure
			return fast;
		} else {
			aTail.next = null;// retain their original structure
			return null;
		}
	}

	public static void main(String[] args) {
		IntersectionofTwoLinkedLists sol = new IntersectionofTwoLinkedLists();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		a1.next = a2;
		a2.next = a3;
		a4.next = a2;
		ListNode res = sol.getIntersectionNode(a1, a4);
		System.out.println("ok");
		System.out.println(res);
	}
}