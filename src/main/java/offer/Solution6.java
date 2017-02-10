package offer;

import java.util.LinkedList;
import java.util.List;
/**
 * 从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * @date 2015-7-14
 */
public class Solution6 {
	/**
	 * 分析：链表只能够从头开始遍历，但是要从尾部先输出。
	 * 思路1：单链表反转
	 * 思路2：栈，先进后出，用LinkedList模拟入栈
	 * Time:O(n) Space:O(n)
	 */
	public List<Integer> printListFromTailToHead(ListNode head) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (; head != null; head = head.next) {
			stack.addFirst(head.val);
		}
		return stack;
	}
	
	/**提交通过AC的代码,但是我认为AC的代码是写的很烂的。
	 *  public ArrayList<Integer> printListFromTailToHead(ListNode head) {
	 *		LinkedList<Integer> stack = new LinkedList<Integer>();
	 *		for (; head != null; head = head.next) {
	 *			stack.addFirst(head.val);
	 *		}
	 *		return new ArrayList<Integer>(stack);
	 *  }
	 */

	public static void main(String[] args) {
		Solution6 sol = new Solution6();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		System.out.println(sol.printListFromTailToHead(l1));
	}
}