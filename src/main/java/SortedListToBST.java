import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> tmp = new ArrayList(1);
        tmp.add(head);
        int len = 0;
        while(head!=null) {
            len++;
            head = head.next;
        }
        return helper(0, len -1,tmp);

    }

    TreeNode helper(int start, int end, List<ListNode> tmp) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        TreeNode leftNode = helper(start, mid -1, tmp);
        ListNode current = tmp.get(0);
        tmp.set(0, current.next);
        TreeNode midNode = new TreeNode(current.val);
        TreeNode rightNode = helper(mid +1, end, tmp);
        midNode.left = leftNode;
        midNode.right = rightNode;
        return midNode;
    }
}
