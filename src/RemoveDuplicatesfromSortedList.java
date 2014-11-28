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
//时间复杂度:O(n) 空间复杂度O(1)
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode tail = dummy;
        ListNode pNex = head;
        while(pNex != null){
        	if(tail.val != pNex.val){
        		tail.next = pNex;
        		tail = pNex;
        	}
        	pNex = pNex.next;
        }
        tail.next = null;
        return dummy.next;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicatesfromSortedList sol = new RemoveDuplicatesfromSortedList();
		ListNode a1 = new ListNode(1);
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