public class PalindromeNumber {
	/**
	 * 基本思路是每次去第一位和最后一位，如果不相同则返回false，否则继续直到位数为0。
	 */
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int div = 1;
		while (div <= (x / 10)) {
			div *= 10;
		}

		while (x > 0) {
			if ((x / div) != (x % 10)) {
				return false;
			}
			x = (x % div) / 10;
			div = div / 100;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeNumber sol = new PalindromeNumber();
		int x = 11;
		System.out.println(sol.isPalindrome(x));
	}

}
