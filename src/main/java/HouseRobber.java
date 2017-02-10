public class HouseRobber {

	// 一维DP: f(n) = a(n) + f(n-2)
	// Time:O(n)  Space:O(1)
	public int rob(int[] nums) {
		int local = 0, maxPrev2 = 0, maxPrev1 = 0;
		for (int num : nums) {
			local = num + maxPrev2;
			maxPrev2 = maxPrev1;
			maxPrev1 = Math.max(local, maxPrev1);
		}
		return maxPrev1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 4, 3, 5 };
		HouseRobber sol = new HouseRobber();
		System.out.println(sol.rob(nums));
	}

}
