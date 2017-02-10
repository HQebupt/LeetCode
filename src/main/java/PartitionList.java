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
public class PartitionList {
	
	// 思路2：dummy1 小于x的linkedlist; dummy2 大于等于x的linkedlist.
	// Time: O(n)  Space:O(1)
	public ListNode partition(ListNode head, int x) {
		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-2);
		ListNode t1 = dummy1, t2 = dummy2, pCur = head;
		while (pCur != null) {
			ListNode pTmp = pCur.next;
			if (pCur.val < x) {
				t1.next = pCur;
				t1 = t1.next;
			} else {
				t2.next = pCur;
				t2 = t2.next;
				t2.next = null;
			}
			pCur = pTmp;
		}
		t1.next = dummy2.next;
		return dummy1.next;
	}
	
	public static void main(String[] args){
		PartitionList sol = new PartitionList();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(2);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(2);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		int x = 3;
		ListNode res = sol.partition(a1, x);
		System.out.println(res);
	}
}