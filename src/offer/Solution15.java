package offer;

/**
 * 反转链表
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * @date 2015-7-16
 */

public class Solution15 {
	// 1.就地反转法
    public ListNode reverseList1(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode pCur = prev.next;
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }
        return dummy.next;
    }
    
	// 2.新建链表,头节点插入法
    public ListNode reverseList2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pCur = head;
        while (pCur != null) {
            ListNode pNex = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = pNex;
        }
        return dummy.next;
    }
}
