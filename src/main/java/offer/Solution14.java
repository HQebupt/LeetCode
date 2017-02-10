package offer;
/**
 * 链表中倒数第k个结点
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @date 2015-7-16
 */
public class Solution14 {
	/**
	 * @param k 按照自然的习惯，倒数第1个，指的是链表的最后一个node。
	 * 所求为"n - k + 1"位置的节点。n 为链表长度。
	 * 思路1：遍历2次，第一次求链表长度；第二次走n-k+1步
	 * 思路2：利用快慢指针，fast先走k-1步，然后一起走。当fast走到尾的时候，slow刚刚好在所求的节点上。
	 * 注意：k值超过链表的长度的时候返回null；链表要判断null。
	 */
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k < 1)
			return null;
		
		ListNode fast = head, slow = head;
		for (int i = 1; i < k; i++) {
			fast = fast.next;
			if (fast == null){
				return null;
			}
		}
		for (; fast.next != null; fast = fast.next) {
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		Solution14 sol = new Solution14();
		int k = 6;
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode res = sol.FindKthToTail(l1, k);
		System.out.println(res);
	}

}
