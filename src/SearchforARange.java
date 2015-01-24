public class SearchforARange {
	public int[] searchRange(int[] A, int target) {
		int bingo = binarySearch(A, target);
		int[] index = { -1, -1 };
		if (bingo == -1)
			return index;
		for (int i = bingo; i >= 0; i--) {
			if (A[i] == A[bingo]) {
				index[0] = i;
			} else {
				break;
			}
		}
		for (int j = bingo; j < A.length; j++) {
			if (A[j] == A[bingo]) {
				index[1] = j;
			} else {
				break;
			}
		}
		return index;
	}

	public int binarySearch(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) >> 1;
			if (target > A[mid]) {
				low = mid + 1;
			} else if (target < A[mid]) {
				high = mid - 1;
			} else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchforARange sol = new SearchforARange();
		int[] A = { 1, 2, 2, 3, 5, 6, 6, 7, 8, 8 };
		int target = 3;
		int[] arr = sol.searchRange(A, target);
		System.out.println("the array:[" + arr[0] + "," + arr[1] + "]");
	}
}