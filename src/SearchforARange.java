import java.util.Arrays;

/**
 * 二分查找的应用，原来这么的简单。
 */
public class SearchforARange {
	public int[] searchRange(int[] A, int target) {
		int bingo = binarySearch(A, target);
		int[] index = { -1, -1 };
		if (bingo == -1)
			return index;

		// 往前找
		for (int i = bingo; i >= 0; i--) {
			if (A[i] == A[bingo]) {
				index[0] = i;
			} else {
				break;
			}
		}

		// 往后找
		for (int j = bingo; j < A.length; j++) {
			if (A[j] == A[bingo]) {
				index[1] = j;
			} else {
				break;
			}
		}
		return index;
	}

	public int binarySearch(int[] a, int target) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (target == a[mid]) {
				return mid;
			} else if (target > a[mid]) {
				low = mid + 1;
			} else if (target < a[mid]) {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchforARange sol = new SearchforARange();
		int[] A = { 1, 2, 2, 3, 5, 6, 6, 7, 8, 8 };
		int target = 3;
		int[] arr = sol.searchRange(A, target);
		System.out.println(Arrays.toString(arr));
	}
}