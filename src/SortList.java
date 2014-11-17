/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class SortList {
    public ListNode sortList(ListNode head) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ListNode p = head;
		while (p != null) {
			arr.add(p.val);
			p = p.next;
		}
		Collections.sort(arr);
		Iterator<Integer> it = arr.iterator();
		p = head;
		while (it.hasNext() && p != null) {
			p.val = it.next();
			p = p.next;
		}
		return head;
	}
}
/**
 * get all the linked chain's values ,and store into ArrayList;
 * use the Collections.sort() to sort.And fill  the sorted values into the linked chain.
 * PS:Collections.sort's implement is Arrays.sort(), more deeply, is MergeSort(nlog(n) timeComplex).
 * Attentions:I do not make out the mergeSort, Need to implement all kinds of sort algorthoms by myself.
 */ 