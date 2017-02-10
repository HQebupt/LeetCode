public class DeleteNodeinaLinkedList {
	/**
	 * 思路: 用后面的val来覆盖前面的val，把最后一个节点删除掉。
	 * 
	 * Two Pointers的做法
	 * - index：指向当前结果的最后一个节点
	 * - pCur：遍历
	 * 注意：此题的遍历的起始位置是`pCur = node.next`
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		ListNode dummy = new ListNode(-1);
		dummy.next = node;
		ListNode index = dummy;
		
		for (ListNode pCur = node.next; pCur != null; index = index.next, pCur = pCur.next) {
			index.next.val = pCur.val;
		}
		index.next = null;
	}

	public static void main(String[] args) {
		DeleteNodeinaLinkedList sol = new DeleteNodeinaLinkedList();
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode t4 = new ListNode(4);
		ListNode t5 = new ListNode(5);
		t1.next = t2;
		t2.next = t3;
		t3.next = t4;
		t4.next = t5;
		System.out.println(t1);
		sol.deleteNode(t3);
		System.out.println(t1);
	}
}