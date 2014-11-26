//时间复杂度：O(m+n) 空间复杂度:0(1)
public class MergeSortedArray {
	// mergeOld的简化版本。
	public void merge(int A[], int m, int B[], int n) {
		int a = m - 1;
		int b = n - 1;
		int cur = m + n - 1;
		while (cur >= 0) {
			if (b < 0 || (a >= 0 && A[a] > B[b])) {
				A[cur--] = A[a--];
			} else {
				A[cur--] = B[b--];
			}
		}
	}

	public void mergeOld(int A[], int m, int B[], int n) {
		int a = m - 1;
		int b = n - 1;
		int cur = m + n - 1;
		while (b >= 0 && a >= 0) {
			if (A[a] > B[b]) {
				A[cur--] = A[a--];
			} else {
				A[cur--] = B[b--];
			}
		}
		while (b >= 0) {
			A[cur--] = B[b--];
		}
		while (a >= 0) {
			A[cur--] = A[a--];
		}
	}
}