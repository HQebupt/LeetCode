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
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
    	if(head == null)
    		return head;
    	ListNode p = head;
        int len = 1;
    	while(p.next!=null){
        	len++;
        	p = p.next;
        }
    	p.next = head;//loop
    	n = n % len;
    	for(int i = 0; i< len - n; i++){
    		p = p.next;
    	}
    	head = p.next;
    	p.next = null;
    	return head;
    }
}