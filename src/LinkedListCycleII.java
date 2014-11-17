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
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		boolean hasCycle = false;
		while (fast != null && (fast.next != null)) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				hasCycle = true;
				break;
			}
		}
		if (!hasCycle) {
			return null;
		} else {
			// find the start of the cycle
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return fast;
		}
	}
}
/**
 * Solution report:http://www.cnblogs.com/byrhuangqiang/p/3796148.html
 */ 