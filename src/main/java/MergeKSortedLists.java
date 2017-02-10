import java.util.List;

public class MergeKSortedLists {
	/**
	 * 链表的归并排序：Time：O(nlogn)  Space：O(n)
	 * 分治法（Divide and Conquer）的一个非常典型的应用。
	 * @param lists 待归并的有序链表
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return divideList(lists, 0, lists.size() - 1);
	}

	/**
	 *  归并排序的第二个阶段，划分子数组。
	 * @param lists
	 * @param left 左边界
	 * @param right 右边界
	 * @return 在数组中，由于数组的特殊性，没有返回值。
	 */
	private ListNode divideList(List<ListNode> lists, int left, int right) {
		if (left < right) {
			int mid = (left + right) >> 1;
			ListNode l1 = divideList(lists, left, mid);
			ListNode l2 = divideList(lists, mid + 1, right);
			return mergeTwoLists(l1, l2);
		} else {
			return lists.get(left);
		}
	}
	
	/**
	 * 归并的第三个阶段：合并两个有序的数组
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy, pa = l1, pb = l2;
		while (pa != null && (pb != null)) {
			if (pa.val < pb.val) {
				tail.next = pa;
				tail = pa;
				pa = pa.next;
			} else {
				tail.next = pb;
				tail = pb;
				pb = pb.next;
			}
		}
		if (pa != null)
			tail.next = pa;
		if (pb != null)
			tail.next = pb;
		return dummy.next;
	}
}
