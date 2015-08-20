public class ReverseInteger {
	private static final int MAXDIV10 = Integer.MAX_VALUE / 10;
	/**
	 * 越界的条件：Math.abs(res) > MAXDIV10
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int mod = x % 10;
			x = x / 10;
			if (Math.abs(res) > MAXDIV10) {
				return 0;
			}
			res = res * 10 + mod;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("max:" + Integer.MAX_VALUE);
		System.out.println("min:" + Integer.MIN_VALUE);
		ReverseInteger sol = new ReverseInteger();
		int x = -21448;
		System.out.println("sol:" + sol.reverse(x));
	}
}
