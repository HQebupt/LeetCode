import java.util.List;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return helper(lists, 0, lists.size() - 1);
	}

	private ListNode helper(List<ListNode> lists, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			return mergeTwoLists(helper(lists, l, m), helper(lists, m + 1, r));
		}
		return lists.get(l);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode headNode = new ListNode(0);
		ListNode cur = headNode;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = l1 != null ? l1 : l2;
		return headNode.next;
	}
}
