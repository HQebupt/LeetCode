import java.util.Arrays;
import java.util.TreeMap;

/**
 * The majority element (if it exists) will also be the median. We can find the
 * median in O(n) and then check that it is indeed a valid majority element in
 * O(n).
 */
public class MajorityElement {
	// Sol 1. Time:O(nlogn) Space:O(n)
	// 时间复杂度可以改进，此解法前提 majority element exists
	public int majorityElement(int[] num) {
		Arrays.sort(num);
		int mid = num.length / 2;
		return num[mid];
	}

	// Sol 2. Best Solution, Moore’s Voting Algorithm
	// returns -1 if there is no element that is the majority element, otherwise that element

	// Time: O(n), Space: O(1)
	int findMajorityElement(int[] num) {
		int size = num.length;
		// first loop : find candidate
		int majarIndex = 0, count = 1;
		for (int i = 1; i < size; i++) {
			if (num[i] == num[majarIndex])
				count++;
			else
				count--;
			if (count == 0) {
				majarIndex = i;
				count = 1;
			}
		}
		// second loop : confirm the candidate
		count = 0;
		for (int i = 0; i < size; i++)
			if (num[i] == num[majarIndex])
				count++;
		if (count > size / 2)
			return num[majarIndex];
		return -1;
	}

	// Sol 3. Time : O(nlogn), Space: O(n)
	// this is wrong answer. Tree map is sorted by key not value.
	public int majorityElement2(int[] num) {
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		for (int e : num) {
			int value = 1;
			if (tmap.containsKey(e)) {
				value += tmap.get(e);
			}
			tmap.put(e, value);
		}
		return tmap.lastKey();
	}

	// Sol 4. Based on quick sort's partition.for some test,Time Limit Exceeded.
	// Time : worst O(n^2), best O(n), average O(nlogn)
	// Space: O(1)
	public int majorityElement3(int[] num) {
		int size = num.length;
		int mid = size >> 1;
		int start = 0;
		int end = size - 1;
		int pos = partition(num, start, end);
		while (pos != mid) {
			if (pos < mid) {
				start = pos + 1;
			} else {
				end = pos - 1;
			}
			mid = (start + end) >> 1;
			if (start <= end)
				pos = partition(num, start, end);
			else
				break;
		}

		// second loop
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (num[pos] == num[i]) {
				count++;
			}
		}
		if (count * 2 <= size)
			return -1;
		else
			return num[pos];
	}

	private int partition(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j] < x) {
				i++;
				int tmp = a[j];
				a[j] = a[i];
				a[i] = tmp;
			}
		}
		i++;
		int tmp = a[i];
		a[i] = x;
		a[r] = tmp;
		return i;
	}

	public static void main(String[] args) {
		MajorityElement sol = new MajorityElement();
		int[] num = { 2, 2, 2 };
		int res = sol.majorityElement3(num);
		System.out.println(res);
	}
}