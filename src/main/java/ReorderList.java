/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReorderList {
    public void reorderList(ListNode head) {
		if (head == null || (head.next == null)) {
			return;
		}
		// fast and slow point find the mid position.
		ListNode fast = head;
		ListNode slow = head;
		while ((fast != null) && (fast.next != null)) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// reverse the last second list.
		ListNode headnode = new ListNode(-1);
		headnode.next = slow;
		ListNode temp = headnode.next;
		while (temp.next != null) {
			ListNode insert = temp.next;
			ListNode currNext = insert.next;
			insert.next = headnode.next;
			headnode.next = insert;
			temp.next = currNext;
		}

		// merge insert
		ListNode firstcur = head;
		ListNode secondcur = headnode.next;
		while (firstcur != slow && (secondcur != slow)) {// at first,I make a mistake in here;
			ListNode firstnex = firstcur.next;
			ListNode secondnex = secondcur.next;
			firstcur.next = secondcur;
			secondcur.next = firstnex;
			firstcur = firstnex;
			secondcur = secondnex;
		}
	}
}
/**
 * Solution report:http://www.cnblogs.com/byrhuangqiang/p/3794587.html
 */ 