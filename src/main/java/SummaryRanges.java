import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		final int len = nums.length;
		List<String> result = new LinkedList<String>();
		for (int start = 0, end = 0; end < len;) {
			if ((end + 1 < len) && (nums[end + 1] == nums[end] + 1)) {
				end++;
			} else {
				if (start == end) {
					result.add(Integer.toString(nums[start]));
				} else {
					result.add(nums[start] + "->" + nums[end]);
				}
				end++;
				start = end;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SummaryRanges sol = new SummaryRanges();
		int[] nums = { 0, 1, 2, 4, 5, 7, 9 };
		List<String> res = sol.summaryRanges(nums);
		System.out.println(res.toString());
	}
}