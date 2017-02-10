import java.util.LinkedList;
import java.util.Queue;

/**
 * VersionB：push O(n); pop O(1)
 * push:
	enqueue in queue2
	enqueue all items of queue1 in queue2, then switch the names of queue1 and queue2
 * pop:
	deqeue from queue1
 */
class MyStackVersionB {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		q2.add(x);
		int size = q1.size();
		for(int i = 0; i < size; i++) {
			q2.add(q1.poll());
		}
		Queue<Integer> tmp = q1;
		q1 = q2;
		q2 = tmp;
	}

	// Removes the element on top of the stack.
	public void pop() {
		q1.poll();
	}

	// Get the top element.
	public int top() {
		return q1.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}
}