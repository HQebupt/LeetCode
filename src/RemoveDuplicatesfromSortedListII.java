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
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        int val = Integer.MAX_VALUE;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode pNex = head;
        boolean flag = false;
        while(pNex != null){
        	if(val != pNex.val){
        		if(!flag){
        			tail.next = new ListNode(val);
        			tail = tail.next;
        			val = pNex.val;
        			flag = false;
        		}else{
        			val = pNex.val;
        			flag = false;
        		}
        	}else{
        		flag = true;
        	}
        	pNex = pNex.next;
        }
        if(!flag)
        	tail.next = new ListNode(val);
        return dummy.next.next;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicatesfromSortedListII sol = new RemoveDuplicatesfromSortedListII();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(1);
		ListNode b1 = new ListNode(3);
		ListNode b2 = new ListNode(3);
		ListNode b3 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = b1;
		b1.next = b2;
		b2.next = b3;
		ListNode res = sol.deleteDuplicates(a1);
		System.out.println(res);
	}
}