package offer;
/**
 * 删除链表中重复的结点
 * 
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * 思路：Two Pointer,一个保留结果；一个遍历。
 * 扩展：Remove Duplicates from Sorted List
 * @date 2015-7-30下午12:04:26
 */
public class Solution55 {
	public ListNode deleteDuplication(ListNode head) {
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;
		ListNode prev = dummy;
		for (ListNode pCur = head; pCur != null; pCur = pCur.next) {
			// 遍历出所有的重复点
			while (pCur.next != null && prev.next.val == pCur.next.val) {
				pCur = pCur.next;
			}
			
			if (prev.next == pCur) {// 单独的点，保留
				prev = prev.next;
			} else { // 重复的点删掉
				prev.next = pCur.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		Solution55 sol = new Solution55();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		System.out.println(sol.deleteDuplication(l1));
	}
}
