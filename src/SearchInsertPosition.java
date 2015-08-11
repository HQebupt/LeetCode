public class SearchInsertPosition {

	// 二分查找
	// Time: O(logn) Space: O(1)
	public int searchInsert(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) >> 1;
			if (target == A[mid]) {
				return mid;
			} else if (target > A[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		// 当循环结束时，如果没有找到目标元素，那么low一定停在恰好比目标大的index上，high一定停在恰好比目标小的index上，
		// 所以推荐这种实现方式,这也是二分查找的性质。
		// return low; // 这两个return语句都是对的。这行是通过找规律得出来的。
		return target > A[mid] ? mid + 1 : mid;
	}

	public static void main(String[] args) {
		SearchInsertPosition sol = new SearchInsertPosition();
		int[] a = { 1, 3, 5, 6 };
		int target = 7;
		System.out.println(sol.searchInsert(a, target));
	}
}