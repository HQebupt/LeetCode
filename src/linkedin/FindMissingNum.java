package linkedin;

public class FindMissingNum {
	
	/**
	 * sol1: 1. Get the sum of numbers total = n*(n+1)/2 
	 * 2. Subtract all the numbers from sum and you will get the missing number. Time:O(n) Space:(1)
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
	 * sol2: 
	 * 1) XOR all the array elements, let the result of XOR be X1. 
	 * 2) XOR all numbers from 1 to n, let XOR be X2. 
	 * 3) XOR of X1 and X2 gives the missing number.
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
		int[] a = { 1,3,2,5};
		System.out.println(sol.solution2(a));
	}
}
