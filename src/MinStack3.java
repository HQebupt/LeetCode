import java.util.Stack;

/**
 * 只用一个栈存储差值，
 * 优化空间复杂度到O(1)。
 * 
 * 致命缺点：无法解决差值存储带来的溢出问题。所以，当做一种优化的思路参考一下。
 * 
 * @author HuangQiang
 * @date 2015-7-28上午11:27:09
 * @file MinStack3.java
 */
public class MinStack3 {
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

	public int getMin() {
		return minValue;
	}
}
