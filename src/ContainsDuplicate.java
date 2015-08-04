import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	// 思路：HashSet来判断是否有重复的元素
	// Time:O(n)  Space:O(n)
	public boolean containsDuplicate(int[] nums) {
		int len = nums.length;
		Set<Integer> set = new HashSet<Integer>(len);
		for (int num : nums) {
			if (set.contains(num)) {
				return true;
			} else {
				set.add(num);
			}
		}
		return false;
	}
}