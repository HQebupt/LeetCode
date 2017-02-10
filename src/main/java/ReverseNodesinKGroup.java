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
// 时间复杂度O(n) 空间O(1)
public class ReverseNodesinKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || k <=1)
			return head;
		ListNode begin = head, end = head, dummy = new ListNode(-1);
		dummy.next = head;//for Input:{1},k=2
		ListNode gHead = dummy;
		while (end != null) {
			for (int i = k; i > 1 && (end != null); i--) {
				end = end.next;
			}
			if(end == null)
				break;
			ListNode tmp = end.next;
			gHead = reverse(gHead, begin, end);
			begin = tmp;
			end = tmp;
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode dummy, ListNode begin, ListNode end) {
		ListNode pNex = begin;
		ListNode tmp = end.next;// for 保存end.next,因为在反转的时候，这个end.next指向会改变。
		while (pNex != tmp) {
			ListNode pCur = pNex.next;
			pNex.next = dummy.next;
			dummy.next = pNex;
			pNex = pCur;
		}
		begin.next = tmp;// 为了维护新的链表能够连接上原来的链表
		return begin;
	}
	
	public static void main(String[] args) {
		ReverseNodesinKGroup sol = new ReverseNodesinKGroup();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		a1.next = a2;
		a2.next = a3;
//		a3.next = a4;
		ListNode res = sol.reverseKGroup(a1,2);
		System.out.println(res);
	}
}