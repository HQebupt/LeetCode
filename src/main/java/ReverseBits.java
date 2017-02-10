public class ReverseBits {
	// you need treat n as an unsigned value
	// Time: O(n)  Space: O(1)
	public int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int bit = (n >> i) & 1;
			res |= bit << (31 - i);
		}
		return res;
	}

	public static void main(String[] args) {
		ReverseBits sol = new ReverseBits();
		int n = 1;
		System.out.println(sol.reverseBits(n));
	}
}