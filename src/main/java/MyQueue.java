import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

// Java编程思想推荐在使用stack的时候，用LinkedList替代。
class MyQueue {
	LinkedList<Integer> inbox = new LinkedList<Integer>();
	LinkedList<Integer> outbox = new LinkedList<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		inbox.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		outbox.pop();
	}

	// Get the front element.
	public int peek() {
		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return inbox.isEmpty() && outbox.isEmpty();
	}
}