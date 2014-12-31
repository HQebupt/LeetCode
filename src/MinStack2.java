// Solution 2: 自己构建数据结构，不会有  Memory Limit Exceeded 的问题。

public class MinStack2 {
	Node top;

	public void push(int x) {
		Node node = new Node(x);
		if (top == null) {
			node.min = x;
			top = node;
		} else {
			int currMin = top.min;
			node.min = Math.min(currMin, x);
			node.next = top;
			top = node;
		}
	}

	public void pop() {
		top = top.next;
	}

	public int top() {
		return top.data;
	}

	public int getMin() {
		return top.min;
	}

	class Node {
		int data;
		int min;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
}
