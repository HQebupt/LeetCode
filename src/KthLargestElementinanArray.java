import java.util.Arrays;

public class KthLargestElementinanArray {
	/**
	 * 偷懒的做法
	 */
	public int findKthLargest0(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	
	/**
	 * 分治的思想，利用partition的过程结果，第k的数，在排序后的len - k的位置。 
	 */
	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		int goal = len - k;
		int left = 0, right = len - 1;
		int index = partition(nums, left, right);
		while (index != goal) {
			if (index < goal) {
				left = index + 1;
			} else {
				right = right - 1;
			}
			index = partition(nums, left, right);
		}
		return nums[goal];

	}

	private int partition(int[] a, int p, int r) {
		int i = p - 1;
		int x = a[r];
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i + 1, r);
		return i + 1;
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		KthLargestElementinanArray sol = new KthLargestElementinanArray();
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 5;
		int res = sol.findKthLargest(nums, k);
		System.out.println(res);
	}
}