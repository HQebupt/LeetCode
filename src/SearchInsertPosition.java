public class SearchInsertPosition {

	// 二分查找
	// Time: O(logn)  Space: O(1)
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
		// return low; 
		return target > A[mid] ? mid + 1 : mid;
	}
}