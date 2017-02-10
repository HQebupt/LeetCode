public class JumpGameII {
	// 贪心思想：多个变量来记录过程，思路和JumpGame类似，细节和变量更多。
	// Time:O(n) Space:O(1)
	public int jump(int[] A) {
		int len = A.length;
		int step = 0, lastReach = 0, maxReach = 0;
		for (int i = 0; (i <= maxReach) && (i < len); i++) {
			int localReach = A[i] + i;
			if (i > lastReach) {
				step++;
				lastReach = maxReach;
			}
			maxReach = maxReach > localReach ? maxReach : localReach;
		}
		return maxReach < len - 1 ? 0 : step;
	}

	public static void main(String[] args) {
		JumpGameII sol = new JumpGameII();
		int[] A = { 2, 3, 1, 1, 4 };
		int res = sol.jump(A);
		System.out.println(res);
	}
}
