public class SingleNumber {
    public int singleNumber(int[] A) {
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			res = res ^ A[i];
		}
		return res;
	}
}
/**
 * ^ operation is the best solution
 */ 