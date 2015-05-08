// 单链表反转的2种方法
public class ReverseLinkedList {
	// 1.就地反转法
	public ListNode reverseList1(ListNode head) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy.next;
		ListNode pCur = prev.next;
		while (pCur != null) {
			prev.next = pCur.next;
			pCur.next = dummy.next;
			dummy.next = pCur;
			pCur = prev.next;
		}
		return dummy.next;
	}

	// 2.新建链表,头节点插入法
	public ListNode reverseList2(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode pCur = head;
		while (pCur != null) {
			ListNode pNex = pCur.next;
			pCur.next = dummy.next;
			dummy.next = pCur;
			pCur = pNex;
		}
		return dummy.next;
	}
	
	// Solution 3: recursively
    ListNode dummy = new ListNode(-1);
	public ListNode reverseListRecu(ListNode head) {
		if (head == null) 
			return head;
		reverse(head);
		return dummy.next;
	}
	
	private void reverse(ListNode head){
		ListNode first = head;
		ListNode rest = first.next;
		if(rest == null) {
			dummy.next = first;
			return;
		}
		reverse(rest);
		first.next.next = first;
		first.next = null;
	}
    
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		ReverseLinkedList sol = new ReverseLinkedList();
		ListNode r1 = sol.reverseList2(n1);
		System.out.println("ok");
		while (r1 != null) {
			System.out.println(r1.val);
			r1 = r1.next;
		}
	}
}
