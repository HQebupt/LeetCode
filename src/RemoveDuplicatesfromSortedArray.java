
public class RemoveDuplicatesfromSortedArray {
	/**
	 * two pointer: i & index 
	 * i : current position
	 * index : 0~index is the single element.
	 * @param A input array
	 * @return the length of A
	 */
	// Time: O(n)   Space: O(1)
	public int removeDuplicates(int[] A) {
		int len = A.length;
		if (A == null || len == 0) 
			return 0;
		int index = 0;
		for (int i = 1; i < len; i++) {
			if (A[i] != A[index]) {
				A[++index] = A[i];
			}
		}
		return index + 1;
	}
}
