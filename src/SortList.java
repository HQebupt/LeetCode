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
public class SortList {
	
	// 链表的堆排序:很基本的题目，要熟练掌握。
	// 时间复杂度 O(nlogn) 空间复杂度,由于堆排序这儿压栈了，应该不是常量的空间，是logn的空间。
    public ListNode sortList(ListNode head) {
    	if(head == null || head.next == null)  
            return head;  
    	ListNode slow = head, fast = head;
    	while(fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	ListNode head2 = slow.next;
    	slow.next = null;
    	ListNode l1 = sortList(head);
    	ListNode l2 = sortList(head2);
    	return merge(l1,l2);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
 		}
		tail.next = l1 == null ? l2 : l1;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		SortList sol = new SortList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4= new ListNode(4);
		ListNode l5 = new ListNode(5);
		l5.next = l4;
		l4.next = l3;
		l3.next = l2;
		l2.next = l1;
		System.out.println(sol.sortList(l5));
		
	}
	
}
