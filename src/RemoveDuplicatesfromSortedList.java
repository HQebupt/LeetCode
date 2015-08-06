// 时间复杂度:O(n) 空间复杂度O(1)
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		ListNode tail = dummy;
		for (ListNode pCur = head; pCur != null; pCur = pCur.next) {
			if ((tail.next == null) || (tail.val != pCur.val)) { // tail.next == null 可以有效解决第一个元素指向的问题。
				tail.next = pCur;
				tail = pCur;
			}
		}
		tail.next = null;
		return dummy.next;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList sol = new RemoveDuplicatesfromSortedList();
		ListNode a1 = new ListNode(Integer.MAX_VALUE);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(2);
		ListNode b1 = new ListNode(4);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(4);
		a1.next = a2;
		a2.next = a3;
		a3.next = b1;
		b1.next = b2;
		b2.next = b3;
		ListNode res = sol.deleteDuplicates(a1);
		System.out.println(res);
	}
}