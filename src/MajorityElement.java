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
		count = 0;
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
		for (int i = 0; i < size; i++)
			if (num[i] == num[majarIndex])
				count++;
		if (count > size / 2)
			return num[majarIndex];
		return -1;
	}

	// Sol 3. Time : O(nlogn), Space: O(n)
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

	public static void main(String[] args) {
		MajorityElement sol = new MajorityElement();
		int[] num = { 1, 2, 2, 3, 3, 3, 3 };
		int res = sol.majorityElement(num);
		System.out.println(res);
	}
}