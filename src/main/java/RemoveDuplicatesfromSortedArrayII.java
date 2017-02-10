
public class RemoveDuplicatesfromSortedArrayII {
	/**
	 * two pointers & variable
	 * 需要一个变量记录元素出现的次数
	 * @param A input array
	 * @return the length of A
	 */
	// Time: O(n)  Space: O(1)
	public int removeDuplicates(int[] A) {
		int len = A.length;
		if (A == null || len == 0) 
			return 0;
		int index = 0;
		int count = 1;
		for (int i = 1; i < len; i++) {
			if(A[i] != A[index]) {
				count = 1;
				A[++index] = A[i];
			} else if (A[i] == A[index] && count != 2){
				count++;
				A[++index] = A[i];
			}
		}
		return index + 1;
	}
}
