public class NumberOf1Bits {
	// Time: O(n) Space: O(1)
	public int hammingWeight(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			final int bit = (n >> i) & 1;
			res += bit;
		}
		return res;
	}

	public static void main(String[] args) {
		NumberOf1Bits sol = new NumberOf1Bits();
		int n = 11;
		System.out.println(sol.hammingWeight(n));
	}
}