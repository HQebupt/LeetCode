public class JumpGame {
	// Sol1 :一维DP
	// Time:O(n) Space:O(n)
	public boolean canJump(int[] nums) {
		int len = nums.length;
		int[] f = new int[len];
		f[0] = nums[0];
		for (int i = 1; i < len; i++) {
			f[i] = Math.max(f[i - 1], nums[i - 1]) - 1;
			if (f[i] < 0)
				return false;
		}
		return f[len - 1] >= 0 ? true : false;
	}

	// Sol2：贪心思想
	// Time:O(n) Space:O(1)
	public boolean canJump2(int[] nums) {
		int len = nums.length;
		int maxCan = 0;
		for (int i = 0; (i < len) && (i <= maxCan); i++) {
			int maxLocal = nums[i] + i;
			maxCan = maxCan > maxLocal ? maxCan : maxLocal;
			if (maxCan >= len - 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		JumpGame sol = new JumpGame();
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(sol.canJump2(nums));
	}
}