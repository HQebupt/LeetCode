package offer;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	ListNode(int x, ListNode l) {
		val = x;
		next = l;
	}

	void setVal(int val) {
		this.val = val;
	}

	void setNode(ListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		String str = "[" + val;
		ListNode cur = next;
		while (cur != null) {
			str += "," + cur.val;
			cur = cur.next;
		}
		return str + "]";
	}

	public ListNode insertionSortList(ListNode head) {
		// dummy is dummy head node,not head pointer.
		ListNode dummy = new ListNode(-1);
		ListNode pre, newNext;
		ListNode oldNext;
		while (head != null) {
			oldNext = head.next;
			pre = searchInsertPosition(dummy, head.val);
			newNext = pre.next;
			pre.next = head;
			head.next = newNext;
			head = oldNext;
		}
		return dummy.next;
	}

	private ListNode searchInsertPosition(ListNode headNode, int val) {
		ListNode pre = headNode;
		ListNode nex = pre.next;
		while ((nex != null) && (nex.val <= val)) {
			pre = nex;
			nex = nex.next;
		}
		return pre;// inserted position is after pre node.
	}

}
