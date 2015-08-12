public class MergeTwo {
	/**
	 * 代码模板
	 */
	// 合并两个有序的数组
	public int[] mergeTwoArray(int[] a, int[] b) {
		int aLen = a.length, bLen = b.length;
		int[] c = new int[aLen + bLen];
		int i = 0, j = 0, k = 0;
		while (i < aLen && j < bLen) {
			if (a[i] < b[i]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}

		while (i < aLen) {
			c[k++] = a[i++];
		}
		while (j < bLen) {
			c[k++] = b[j++];
		}
		return c;
	}

	// 合并两个有序的链表
	public ListNode mergeTwoLists(ListNode listA, ListNode listB) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy, pa = listA, pb = listB;
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

		if (pa != null) {
			tail.next = pa;
		}
		if (pb != null) {
			tail.next = pb;
		}
		return dummy.next;
	}
}
