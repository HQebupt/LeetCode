package linkedin;

/**
 * A zero-indexed array A consisting of N different integers is given. The array
 * contains integers in the range [1..(N + 1)], which means that exactly one
 * element is missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * int solution(int A[], int N);
 * 
 * that, given a zero-indexed array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
 * the missing element.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000]; the elements of A are all
 * distinct; each element of array A is an integer within the range [1..(N +
 * 1)]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(1), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * Copyright 2009–2015 by Codility Limited. All Rights Reserved. Unauthorized
 * copying, publication or disclosure prohibited.
 * 
 * @author hadoop
 * @date 2015-5-17
 */
public class FindMissingNum {

	/**
	 * sol1: 1. Get the sum of numbers total = n*(n+1)/2 2. Subtract all the
	 * numbers from sum and you will get the missing number. Time:O(n) Space:(1)
	 * 注意：如果使用加入法
	 */
	public int solution(int[] A) {
		int len = A.length;
		int total = len + 1;
		for (int i = 0; i < len; i++) {
			total = total - A[i] + (i + 1);
		}
		return (int) total;
	}

	/**
	 * sol2: 1) XOR all the array elements, let the result of XOR be X1. 2) XOR
	 * all numbers from 1 to n, let XOR be X2. 3) XOR of X1 and X2 gives the
	 * missing number.
	 */
	public int solution2(int[] A) {
		int len = A.length;
		int x1 = 1;
		int x2 = A[0];
		for (int i = 2; i <= len + 1; i++) {
			x1 = x1 ^ i;
		}
		for (int i = 1; i < len; i++) {
			x2 = x2 ^ A[i];
		}
		return (x1 ^ x2);
	}

	public static void main(String[] args) {
		FindMissingNum sol = new FindMissingNum();
		int[] a = { 1, 3, 2, 5 };
		System.out.println(sol.solution2(a));
	}
}
