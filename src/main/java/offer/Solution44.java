package offer;

import java.util.Arrays;

public class Solution44 {
	// 修正题目：超过数组一半的元素，找到就返回；没有就返回 -1.
	// Solution 1：先排序，如果存在这个数，一定在中位数的位置上。
	// Time:O(nlogn) 因为排序
	public int moreThanHalfNum_Solution(int[] arr) {
		int len = arr.length;
		Arrays.sort(arr);
		int res = arr[len / 2];
		int count = 0;
		for (int a : arr) {
			if (res == a) {
				count++;
			}
		}
		return count > len / 2 ? res : -1;
	}

	// Solution 2:两两比较，不同就抵消
	/*
	 * 代码写的很不优雅。边界条件和特殊的用例考虑不足。 Time：O(n)
	 */
	public int moreHalfArray(int[] arr) {
		int mid = Integer.MIN_VALUE, count = 0;
		int len = arr.length;
		for (int i = 0; i < len; i += 2) {
			int first = arr[i];
			int second = (i + 1) < len ? arr[i + 1] : Integer.MIN_VALUE;
			if (first == second) {
				if (count == 0) {
					count++;
					mid = first;
				} else if (mid == first) {
					count++;
				} else {
					count--;
				}
			}
		}
		System.out.println(mid);

		count = 0;
		for (int a : arr) {
			if (mid == a) {
				count++;
			}
		}
		return count > len / 2 ? mid : -1;
	}
	
	// Solution 3：根据寻找数组中K最小的数的思路。这个数是中位数，k = len / 2。最后在遍历一下看看，是不是出现了一半。
	
	
	// 下面是另外一题：很经典的一题目。
	// 寻找数组中K小的数：从0开始
	/**
	 * 由于partition的复杂度在O(n),这个的平均复杂度还是O(n),最坏的情况和快排一样O(n^2)
	 */
	int kLess(int[] arr, int p ,int r, int k) {
		if (p < r) {
			int q = partition(arr, p, r, k);
			if (q == k) {
				return arr[q];
			} else if (q > k) {
				return kLess(arr, p, q - 1, k);
			} else 
				return kLess(arr, q + 1, r, k);
		}
		return -1;
	}

	private int partition(int[] arr, int p, int r, int k) {
		int x = arr[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (arr[j] <= x) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, r);
		return i + 1;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		Solution44 sol = new Solution44();
		int[] arr = {0,1,2,3,4,5,6,7,8};
		int k = arr.length / 2;
		System.out.println(sol.kLess(arr, 0, arr.length - 1, k));
	}
}
