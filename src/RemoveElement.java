public class RemoveElement {
	// Two pointer.
	// Time: O(n)  Space: O(1)
	public int removeElement(int[] A, int elem) {
		int index = -1; // 0 - index 是所需要的数组。
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[++index] = A[i];
			}
		}
		return index + 1;
	}
}