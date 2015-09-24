import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

public class SlidingWindowMaximum {
	// 暴力解法:采用左右边界滑动窗口
	// Time:O(n*k)
	public int[] maxSlidingWindow1(int[] nums, int k) {
		int len = nums.length;
		if (len == 0)
			return new int[0];
		int left = 0, right = k - 1;
		int[] res = new int[len - k + 1];
		while (right < len) {
			res[left] = nums[left];
			for (int i = left + 1; i <= right; i++) {
				res[left] = Math.max(res[left], nums[i]);
			}
			left++;
			right++;
		}
		return res;
	}

	// 用TreeSet实现堆，减少查询最大值的效率，降低了复杂度。
	// Wrong Answer:无法解决重复元素的问题。
	// Time:O(nlogK) Space:O(k)
	public int[] maxSlidingWindow2(int[] nums, int k) {
		int len = nums.length;
		if (len == 0)
			return new int[0];
		int[] res = new int[len - k + 1];
		TreeSet<Integer> heap = new TreeSet<Integer>();
		for (int i = 0; i < k - 1; i++) {
			heap.add(nums[i]);
		}
		for (int i = k - 1; i < len; i++) {
			heap.add(nums[i]);
			int index = i - k + 1;
			res[index] = heap.last();
			heap.remove(nums[index]);
		}
		return res;
	}

	// 用双端队列来解决，时间复杂度降到了O(n)
	// Time:O(n) Space:O(k)
	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		if (len == 0)
			return new int[0];
		int[] res = new int[len - k + 1];
		Deque<Integer> dq = new LinkedList<Integer>();
		for (int i = 0; i < len; i++) {
			int data = nums[i];
			while (!dq.isEmpty() && dq.getLast() < data) {
				dq.removeLast();
			}
			dq.add(data);
			if (i < k - 1) {
				continue;
			}
			int index = i - k + 1;
			res[index] = dq.getFirst();
			if (res[index] == nums[index]) {
				dq.removeFirst();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum sol = new SlidingWindowMaximum();
		int[] nums = { 1, 3, -1, -3, 5 };
		int k = 3;
		int[] res = sol.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(res));
	}
}