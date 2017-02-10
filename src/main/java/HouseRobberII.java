public class HouseRobberII {
	/**
	 * 现在房子排成了一个圆圈，则如果抢了第一家，就不能抢最后一家，因为首尾相连了，
	 * 所以第一家和最后一家只能抢其中的一家，或者都不抢，那我们这里变通一下，
	 * 如果我们把第一家和最后一家分别去掉，各算一遍能抢的最大值，然后比较两个值取其中较大的一个即为所求。
	 */
	
	//特殊用例： nums = [1,1] Expected Output: 1.
	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 1) {
			return nums[0];
		}
		int containFirst = robSub(nums, 0, len - 2);
		int containLast = robSub(nums, 1, len - 1);
		return Math.max(containFirst, containLast);
	}

	private int robSub(int[] nums, int p, int q) {
		int local = 0, maxPre = 0, max = 0;
		for (int i = p; i <= q; i++) {
			local = nums[i] + maxPre;
			maxPre = max;
			max = Math.max(max, local);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 4, 5 };
		HouseRobberII sol = new HouseRobberII();
		System.out.println(sol.rob(nums));
	}

}
