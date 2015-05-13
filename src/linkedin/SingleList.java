package linkedin;

public class SingleList {
	int length(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	public static void main(String[] args) {
		SingleList sol = new SingleList();
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		int res = sol.length(a1);
		System.out.println(res);
	}
}
