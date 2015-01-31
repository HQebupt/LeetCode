public class NextPermutation {
	// 4 Steps Solved
	// Time: O(n)   Space: O(1)
	// final关键字提高了效率：254 ms --> 208ms
	public void nextPermutation(int[] num) {
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
		NextPermutation sol = new NextPermutation();
		int[] num = {  1,1,5 };
		sol.nextPermutation(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}
}