import java.util.Stack;

// Solution 1: 如果内置的数据结构, 必须用Stack(not LinkedList), 而且 最小栈不能够储存所有的最小值,否则 Memory Limit Exceeded.
// Solution 2: 自己构建数据结构储存
public class MinStack1 {
	private Stack<Integer> data = new Stack<Integer>();
	private Stack<Integer> minValue = new Stack<Integer>();

	public void push(int x) {
		data.push(x);
		if (minValue.isEmpty() || x <= minValue.peek())
			minValue.push(x);
	}

	public void pop() {
		int value = data.pop();
		if (value == minValue.peek())
			minValue.pop();
	}

	public int top() {
		return data.peek();
	}

	public int getMin() {
		return minValue.peek();
	}
}
