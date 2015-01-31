import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {

	// Solution 2: Cantor Set
	// Time: O(n^2)  Space:O(n)
	// Refer:http://blog.csdn.net/linhuanmars/article/details/22028697
	public String getPermutation(int n, int k) {
		if (n <= 0)
			return "";
		k--;
		StringBuilder res = new StringBuilder();
		int factorial = 1;
		List<Integer> nums = new LinkedList<Integer>();
		for (int i = 2; i < n; i++) {
			factorial *= i;
		}
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		int round = n - 1;
		while (round >= 0) {
			int index = k / factorial;
			k %= factorial;
			res.append(nums.get(index));
			nums.remove(index);
			if (round > 0)
				factorial /= round;
			round--;
		}
		return res.toString();
	}

	// Solution 1:
	// 暴力解法：借用NextPermutation方法，调用k - 1次
	// Time: O(n*k) Space:O(n)
	public String getPermutation1(int n, int k) {
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}

		for (int i = 1; i < k; i++) {
			nextPermutation(num);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(num[i]);
		}
		return sb.toString();
	}

	// copy from NextPermutation.java
	private void nextPermutation(int[] num) {
		final int length = num.length;
		// step 1 : find the partition number.
		int pnum = length - 1;
		while (pnum > 0) {
			if (num[pnum - 1] < num[pnum]) {
				break;
			}
			pnum--;
		}
		pnum--;

		// find the partition number.
		if (pnum != -1) {

			// step 2 : find the change number.
			int cnum = length - 1;
			while (cnum >= 0 && num[cnum] <= num[pnum]) {
				cnum--;
			}

			// step 3 : swap Partition Number & Change Number.
			final int swap = num[pnum];
			num[pnum] = num[cnum];
			num[cnum] = swap;
		}

		// step 4 : reverse the digit on the right of parition number.
		int left = pnum + 1;
		int right = length - 1;
		while (left < right) {
			final int swap2 = num[left];
			num[left] = num[right];
			num[right] = swap2;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		PermutationSequence sol = new PermutationSequence();
		int n = 2;
		int k = 1;
		System.out.println(sol.getPermutation(n, k));
	}
}
