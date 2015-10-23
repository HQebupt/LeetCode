import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
	// Java 使用堆的数据结构，用PriorityQueue
	Queue<Long> small = new PriorityQueue<Long>(),
			large = new PriorityQueue<Long>();

	// Adds a number into the data structure.
	public void addNum(int num) {
		large.add((long) num);
		small.add(-large.poll());
		if (large.size() < small.size() ) {
			large.add(-small.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		return large.size() > small.size() ? large.peek()
				: (large.peek() - small.peek()) / 2.0d;
	}
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();