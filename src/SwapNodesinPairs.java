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
// 时间复杂度O(n) 空间复杂度 O(1)
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        if(head == null)
        	return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(pre != null && cur != null){
        	ListNode tmp = cur.next;
        	tail.next = cur;
        	cur.next = pre;
        	tail = pre;
        	pre = tmp;
        	cur = (tmp == null || tmp.next == null) ? null : tmp.next;
        }
        tail.next = pre;
        return dummy.next;
    }
    
    public static void main(String[] args) {
    	SwapNodesinPairs sol = new SwapNodesinPairs();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		ListNode res = sol.swapPairs(a1);
		System.out.println(res);
	}
    
}