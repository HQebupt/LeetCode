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
// 时间复杂度:O(n) 空间复杂度O(1)
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
	    if(head == null)
	        return head;
	    ListNode dummy = new ListNode(Integer.MAX_VALUE);
	    dummy.next = head;
	    ListNode prev = dummy;
	    ListNode pCur = head;
	    while (pCur != null)
	    {
	        while(pCur.next != null && prev.next.val == pCur.next.val){
	            pCur = pCur.next;
	        }
	        if(prev.next == pCur){ // 找到单独的元素
	            prev = prev.next;
	        } else{ // 剔除重复的元素
	            prev.next = pCur.next;
	        }
	        pCur = pCur.next;
	    }
	    return dummy.next;
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