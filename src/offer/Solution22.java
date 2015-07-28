package offer;

import java.util.LinkedList;
/**
 * 栈的压入、弹出序列
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 
 * 思路：如果下一个弹出的数字刚好是栈顶数字，则直接弹出。
 * 若下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
 * 若所有的数字都压入栈了仍没有找到下一个弹出的数字，则表明该序列不可能是一个弹出序列。
 * @date 2015-7-28下午12:38:03
 */


public class Solution22 {
	/**
	 * i 是pushA的下标， j是popA的下标；stack是辅助的栈。
	 */
	public boolean isPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0)
			return false;
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int j = 0;
		for (int i = 0; i < pushA.length;) {
			if ((!stack.isEmpty()) && (popA[j] == stack.getLast())) {
				stack.removeLast();
				j++;
			} else {
				stack.addLast(pushA[i]);
				i++;
			}
		}
		
		// 所有输入数据都已经入栈了，现在只能够出栈，一一相等，若不等，就不是弹出序列。
		for (; j < popA.length; j++) {
			if ((!stack.isEmpty()) && (popA[j] == stack.getLast())) {
				stack.removeLast();
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution22 sol = new Solution22();
		int[] pushA = {};
		int[] popA = {};
		boolean res = sol.isPopOrder(pushA, popA);
		System.out.println(res);
	}

}
