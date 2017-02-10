import java.util.Arrays;

public class ProductofArrayExceptSelf {
	/**
	 * Time: O(n)  Space:O(1)
	 * 借用输出结果的数组res，不需要额外的O(n) 空间
	 * @param nums = { 1,  2,  3, 4}
	 * @return res = { 24, 12, 8, 6}
	 */
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		res[0] = 1;
		for (int i = 1; i < len; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}

		int right = 1;
		for (int i = len - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;

	}

	public static void main(String[] args) {
		ProductofArrayExceptSelf sol = new ProductofArrayExceptSelf();
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(sol.productExceptSelf(nums)));
	}
}