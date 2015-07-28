package offer;
/**
 * 二叉搜索树的后序遍历序列
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * 思路：分治法
 * 在后序遍历得到的序列中，最后一个数字是树的根结点的值，数组中前面的数字可分为两个部分：
 * 第一部分是左子树结点的值，它们都比根结点的值小；
 * 第二部分是右子树结点的值，它们都比根结点的值大。
 * 
 * @date 2015-7-28下午07:00:33
 */

public class Solution24 {
	public boolean verifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0)
			return false;
		return bstHelp(sequence, 0, sequence.length - 1);
	}

	// 辅助函数
	private boolean bstHelp(int[] seq, int start, int end) {
		// 分治到最后，只有一个节点的时候，为true。
		if (start >= end)
			return true;
		int root = seq[end];
		
		// 左子树的节点小于根结点
		int i = start;
		for (; i < end; i++) {
			if (seq[i] > root) {
				break;
			}
		}
		
		// 右子树的节点大于根结点
		int j = i;
		for (; j < end; j++) {
			if (seq[j] < root) {
				return false;
			}
		}

		// 判断左右子树是不是二叉搜索树
		boolean left = bstHelp(seq, start, i - 1);
		boolean right = bstHelp(seq, i, end - 1);
		return left & right;
	}

	public static void main(String[] args) {
		Solution24 sol = new Solution24();
		int[] seq = { 5, 6, 9, 11, 10, 8 };
		System.out.println(sol.verifySquenceOfBST(seq));
	}
}
