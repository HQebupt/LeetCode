public class PowerofTwo {
	// Solution 1: Time O(32) Space O(1)
	public boolean isPowerOfTwo(int n) {
		int count1 = 0;
		for (; n > 0;) {
			int tmp = n & 1;
			count1 += tmp;
			n = n >> 1;
		}
		boolean is = (count1 == 1);
		return is;
	}

	// Solution 2: Time O(1)  Space O(1)
	public boolean isPowerOfTwo2(int n) {
		boolean is = false;
		if (n > 0) {
			is = ((n - 1) & n) == 0;
		}
		return is;
	}

}