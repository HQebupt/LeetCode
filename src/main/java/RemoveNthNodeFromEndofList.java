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
// 时间复杂度 O(n) 空间复杂度 O(1)
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n == 0){
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;
		for (int i = n; i > 0; i--) {
			fast = fast.next;
		}
		while(fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		RemoveNthNodeFromEndofList sol = new RemoveNthNodeFromEndofList();
		ListNode a1 = new ListNode(1);
		ListNode res = sol.removeNthFromEnd(a1, 1);
		System.out.println("ok");
		System.out.println(res);
	}
}