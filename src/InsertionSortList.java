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
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
		// dummy is dummy head node,not head pointer.
		ListNode dummy = new ListNode(-1);
		ListNode pre, newNext;
		ListNode oldNext;
		while (head != null) {
			oldNext = head.next;
			pre = searchInsertPosition(dummy, head.val);
			newNext = pre.next;
			pre.next = head;
			head.next = newNext;
			head = oldNext;
		}
		return dummy.next;
	}

	private ListNode searchInsertPosition(ListNode headNode, int val) {
		ListNode pre = headNode;
		ListNode nex = pre.next;
		while ((nex != null) && (nex.val <= val)) {
			pre = nex;
			nex = nex.next;
		}
		return pre;// inserted position is after pre node.
	}
}
/**
 * solution report: http://www.cnblogs.com/byrhuangqiang/p/3784209.html
 * 
 */ 