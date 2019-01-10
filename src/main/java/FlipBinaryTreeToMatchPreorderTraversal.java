import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        LinkedList<TreeNode> s = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        int index = 0;
        if (root == null) {
            return res;
        }
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode p = s.pollLast();
            if (p.val != voyage[index++]) {
                return Arrays.asList(-1);
            }
            if (p.right != null && p.left != null) {
                if (p.right.val != voyage[index]) {
                    s.addLast(p.right);
                    s.addLast(p.left);
                } else {
                    res.add(p.val);
                    s.addLast(p.left);
                    s.addLast(p.right);
                }
            } else {
                if (p.right != null) {
                    s.addLast(p.right);
                }
                if (p.left != null) {
                    s.addLast(p.left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FlipBinaryTreeToMatchPreorderTraversal sol = new FlipBinaryTreeToMatchPreorderTraversal();
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        int[] voyage = {2,4,3,1,5};
        System.out.println(sol.flipMatchVoyage(t1, voyage));
    }
}
