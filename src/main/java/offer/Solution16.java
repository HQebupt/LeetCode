package offer;
/**
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @date 2015-7-16
 */
public class Solution16 {
	/**
	 * 用头结点，两个指针，遍历一遍。注意合并的过程，程序的特殊输入：null等。
	 * Time：O(n)  Space:O(1)
	 */
	public ListNode merge(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		while ((list1 != null) && (list2 != null)) {
			if (list1.val < list2.val) {
				tail.next = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		}
		if (list1 == null) {
			tail.next = list2;
		}
		if (list2 == null) {
			tail.next = list1;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		Solution16 sol = new Solution16();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;

		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(6);
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		System.out.println(sol.merge(null, null));
	}
}
