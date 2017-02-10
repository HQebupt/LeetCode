import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	// 思路：HashTable思想来存储
	// Time:O(n) Space:O(n)
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(len);
		for (int i = 0; i < len; i++) {
			if (map.containsKey(nums[i])) {
				int diff = i - map.get(nums[i]);
				if (diff <= k)
					return true;
			}
			map.put(nums[i], i); // 不管有没有这个num，都要更新Map的值。为了通过这样的测试用例:{1,0,1,1},1
		}
		return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicateII sol = new ContainsDuplicateII();
		int[] nums = {1,2,3,4,5,2,3,1};
		int k = 2;
		System.out.println(sol.containsNearbyDuplicate(nums, k));
	}
}