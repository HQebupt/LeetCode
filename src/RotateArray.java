// Refer: http://www.geeksforgeeks.org/array-rotation/  文章是左移数组，lc的题目是右移，没本质区别。
// http://www.cs.bell-labs.com/cm/cs/pearls/s02b.pdf
public class RotateArray {

	// Sol 1 (Use temp array)
	// Time: O(n) Space: O(k)
	public void rotate1(int[] nums, int k) {
		final int length = nums.length;
		// 右移k位 等于 左移 n - k
		k = length - k % length;
		int[] tmps = new int[k];
		for (int i = 0; i < k; i++) {
			tmps[i] = nums[i];
		}
		for (int i = 0; i < length - k; i++) {
			nums[i] = nums[i + k];
		}
		for (int i = length - k, j = 0; i < length; i++, j++) {
			nums[i] = tmps[j];
		}
	}

	// Sol 2 (Rotate one by one)
	// Time: O(n * k) Space: O(1)
	public void rotate2(int[] nums, int k) {
		final int length = nums.length;
		k = k % length;
		for (int i = 0; i < k; i++) {
			final int tmp = nums[length - 1];
			for (int j = length - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			nums[0] = tmp;
		}
	}

	// Sol 3 (A Juggling Algorithm)
	// Time: O(n) Space: O(1)
	public void rotate3(int[] nums, int d) {
		final int length = nums.length;
		d = length - d % length;
		final int gcdNum = gcd(length, d);
		for (int i = 0; i < gcdNum; i++) {
			final int tmp = nums[i];
			int j = i;
			while (true) {
				int k = j + d;
				if (k >= length)
					k -= length;
				if (k == i)
					break;
				nums[j] = nums[k];
				j = k;
			}
			nums[j] = tmp;
		}
	}

	int gcd(final int a, final int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}