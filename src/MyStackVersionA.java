import java.util.LinkedList;
import java.util.Queue;

/**
 * VersionA：push高效 O(1); pop O(n)
 * push:
	enqueue in queue1
 * pop:
	while size of queue1 is bigger than 1, pipe dequeued items from queue1 into queue2
	dequeue and return the last item of queue1, then switch the names of queue1 and queue2
 */
class MyStackVersionA {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		q1.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		top();
		q1.poll();
		Queue<Integer> tmp = q1;
		q1 = q2;
		q2 = tmp;
	}

	// Get the top element.
	public int top() {
		int size = q1.size();
		if (size > 1) {
			int count = size - 1;
			for (int i = 0; i < count; i++) {
				q2.add(q1.poll());
			}
		}
		return q1.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}

	public static void main(String[] args) {
		MyStackVersionA  stack = new MyStackVersionA();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		stack.pop();
		System.out.println(stack.top());
    }
}