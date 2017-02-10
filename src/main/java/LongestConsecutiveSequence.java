import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	// hash table: 空间换时间
	// Time: O(n)  Space: O(n)
	public int longestConsecutive(int[] num) {
		int max = 0;
		// create hash set for input array.
		Set<Integer> set = new HashSet<Integer>();
		for (int e : num) {
			set.add(e);
		}

		// search consecutive
		for (int e : num) {
			int pre = e - 1;
			int next = e + 1;
			int count = 1;
			set.remove(e);
			while (set.contains(pre)) {
				count++;
				set.remove(pre);
				pre--;
			}
			while (set.contains(next)) {
				count++;
				set.remove(next);
				next++;
			}
			// find max
			max = Math.max(max, count);
		}
		return max;
	}
	/**
	 * reference:
	 * http://www.cnblogs.com/shawnhue/archive/2013/05/26/leetcode_128.html
	 * http://blog.csdn.net/souldak/article/details/11473425
	 * http://fisherlei.blogspot.com/2013/02/leetcode-longest-consecutive-sequence.html
	 */
}
