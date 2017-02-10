package offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * Reference 有道云笔记或者博客园：最小栈
 * 
 * @author HuangQiang
 * @date 2015-7-28上午11:58:11
 * @file Solution20.java
 */
public class Solution20 {

	private Stack<Integer> diff = new Stack<Integer>();
	private int minValue;

	public void push(int x) {
		if (diff.isEmpty()) {
			minValue = x;
			diff.push(0);
		} else {
			int compare = x - minValue;
			diff.push(compare);
			minValue = compare < 0 ? x : minValue;
		}
	}

	public void pop() {
		int top = diff.peek();
		minValue = top < 0 ? (minValue - top) : minValue;
		diff.pop();
	}

	public int top() {
		int top = diff.peek();
		return top > 0 ? top + minValue : minValue;
	}

	public int min() {
		return minValue;
	}
}