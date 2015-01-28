import java.util.HashMap;
import java.util.Map;

/**
 * Reference
 * http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
 */
public class TwoSum {
	
	// Solution 1 & 2 思路一样，但是效率我觉得 Solution 2 高于 Solution 1.
	// Time: O(n)  Space: O(n)
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] indexs = new int[2];

		for (int i = 0; i < numbers.length; i++) {
			System.out.println("i:" + i);
			if (map.containsKey(numbers[i])) {
				System.out.println("if map:" + map);
				int index = map.get(numbers[i]);
				indexs[0] = index + 1;
				indexs[1] = i + 1;
				break;
			} else {
				map.put(target - numbers[i], i);
				System.out.println("else map:" + map);
			}
		}
		return indexs;
	}
	
	// Solution 2:
	// 使用HashMap。把每个数都存入map中，然后再逐个遍历，查找是否有 target – nubmers[i]。
	// 此解法不用担心 数组里面有重复的元素
	// Time: O(n)  Space: O(n)
	public int[] twoSum2(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] indexs = new int[2];
		for(int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}

		for (int i = 0; i < numbers.length; i++) {
			final int gap = target - numbers[i];
			if (map.containsKey(gap) && map.get(gap) > i) { // 这个技巧可以有效的解决数组的重复元素
				indexs[0] = i + 1;
				indexs[1] = map.get(gap) + 1;
				break;
			}
		}
		return indexs;
	}
}
