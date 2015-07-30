package offer;
/**
 * 链表中环的入口结点
 * 
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * 
 * 思路：快慢指针，重合即有环；有环则指向头指针，重合即环的起点。
 * Time：O(n) Space:O(1)
 * @date 2015-7-30上午11:21:18
 */
public class Solution54 {
	public ListNode entryNodeOfLoop(ListNode head) {
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

		// find the start of cycle
		if (!hasCycle) {
			return null;
		}
		for (fast = head; fast != slow;) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}
