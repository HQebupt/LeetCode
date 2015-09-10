public class ContainerWithMostWater {
	/*
	 * 暴力枚举
	 * Time:O(n^2) Space:O(1)
	 */
	public int maxArea0(int[] height) {
		int len = height.length;
		int res = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				int tmp = Math.min(height[i], height[j]) * (j - i);
				res = Math.max(res, tmp);
			}
		}
		return res;
	}

	/*
	 * 两边夹逼
	 * Time:O(n) Space:O(1)
	 */
	public int maxArea(int[] height) {
		int len = height.length;
		int left = 0, right = len - 1;
		int res = 0;
		while (left < right) {
			int local = Math.min(height[left], height[right]) * (right - left);
			res = Math.max(res, local);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ContainerWithMostWater sol = new ContainerWithMostWater();
		int[] height = { 4, 6, 2, 6, 7, 11, 2 };
		System.out.println(sol.maxArea(height));
	}
}