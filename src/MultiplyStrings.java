public class MultiplyStrings {
	/**
	 * 1 翻转string 
	 * 2 建立中间结果数组，循环遍历两个string，把单位的乘积累加到数组相应的位置 
	 * 3 处理进位并输出 
	 * 4 注意前导零的测试用例和测试用例（0,0）
	 * Time: O(n^2) ; Space: O(m + n)
	 */
	public String multiply(String num1, String num2) {
		StringBuilder s1 = new StringBuilder(num1).reverse();
		StringBuilder s2 = new StringBuilder(num2).reverse();

		final int len1 = s1.length();
		final int len2 = s2.length();
		int[] tmp = new int[len1 + len2 - 1];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				tmp[i + j] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
			}
		}

		StringBuilder result = new StringBuilder(len1 + len2);
		for (int i = 0; i < tmp.length; i++) {
			int mod = tmp[i] % 10;
			int carry = tmp[i] / 10;
			if (i + 1 < tmp.length) {
				tmp[i + 1] += carry;
				result.insert(0, mod);
			} else {
				result.insert(0, tmp[i]);
			}
		}

		while (result.charAt(0) == '0' && result.length() > 1) {
			result.deleteCharAt(0);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings sol = new MultiplyStrings();
		String num1 = "000289";
		String num2 = "758";
		String res = sol.multiply(num1, num2);
		System.out.println(res);
	}
}