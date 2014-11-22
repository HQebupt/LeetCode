public class ReverseInteger {
	private static final int MAXDIV10 = Integer.MAX_VALUE / 10;

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
		ReverseInteger sol = new ReverseInteger();
		int x = -21448;
		System.out.println("sol:" + sol.reverse(x));
	}
}
