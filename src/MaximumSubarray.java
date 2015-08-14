import java.util.Arrays;

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
	
	public int[] maxSubArrayRange(int[] arr) {
		int len = arr.length;
		int max = arr[0], local = arr[0];
		int[] maxIndex = {0, 0}, localIndex = {0, 0};
		for (int i = 1; i < len; i++) {
			int tmp = local + arr[i];
			if (tmp > arr[i]) {
				local = tmp;
				localIndex[1] = i;
			} else {
				local = arr[i];
				localIndex[0] = i;
				localIndex[1] = i;
			}
			if (max < local) {
				max = local;
				maxIndex[0] = localIndex[0];
				maxIndex[1] = localIndex[1];
			}
		}
		return maxIndex;
	}
	
	public static void main(String[] args) {
		MaximumSubarray sol = new MaximumSubarray();
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5};
		System.out.println(Arrays.toString(sol.maxSubArrayRange(arr)));
	}
}