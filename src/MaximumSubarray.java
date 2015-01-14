public class MaximumSubarray {
	// Time:O(n)  Space:O(1)
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int maxLocal = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			maxLocal = Math.max(maxLocal + A[i], A[i]);
			max = Math.max(maxLocal, max);
		}
		return max;
	}
}