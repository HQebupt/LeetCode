// Reference: http://www.cnblogs.com/springfor/p/3861890.html
// http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
public class MedianofTwoSortedArrays {
	// 非常经典的题：重新code，好好总结
	// 算法：***
	// 实现：****
	// Time: O( log(m + n) )   Space: O( log(m + n) )
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int total = m + n;
		if (total % 2 != 0)
			return (double) findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);// k传得是第k个，index实则k-1
		else {
			double x = findKth(A, 0, m - 1, B, 0, n - 1, total / 2);// k传得是第k个，index实则k-1
			double y = findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);// k传得是第k个，index实则k-1
			return (double) (x + y) / 2;
		}
	}
	
	/**
	 * 
	 * @param A
	 * @param astart
	 * @param aend
	 * @param B
	 * @param bstart
	 * @param bend
	 * @param k
	 * @return
	 */
	private int findKth(int[] A, int astart, int aend, int[] B,	int bstart, int bend, int k) {
		int m = aend - astart + 1;
		int n = bend - bstart + 1;
		
		// always assume that m <= n
		if (m > n) return findKth(B, bstart, bend, A, astart, aend, k);
		if (m == 0) return B[k - 1];
		if (k == 1)	return Math.min(A[astart], B[bstart]);
		
		// divide k into two parts
		int ia = Math.min(k / 2, m);
		int ib = k - ia;
		if (A[astart + ia - 1] < B[bstart + ib - 1])
			return findKth(A, astart + ia, aend, B, bstart, bend, k - ia);
		else if (A[astart + ia - 1] > B[bstart + ib - 1])
			return findKth(A, astart, aend, B, bstart + ib, bend, k - ib);
		else
			return A[astart + ia - 1];
	}
}