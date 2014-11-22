public class StringtoInteger {
	// 时间复杂度O(n),空间复杂度O(1).
	public int atoi(String str) {
		int len = str.length();
		int i = 0;
		int sign = 1;
		while ((i < len) && Character.isWhitespace(str.charAt(i))) {
			i++;
		}
		if ((i < len) && str.charAt(i) == '+') {
			i++;
		} else if ((i < len) && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		int res = 0;
		while ((i < len) && (Character.isDigit(str.charAt(i)))) {
			int num = Character.getNumericValue(str.charAt(i));
			int div = Integer.MAX_VALUE / 10;
			int mod = Integer.MAX_VALUE % 10;
			if (res > div || (res == div && num > mod))
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			res = res * 10 + num;
			i++;
		}	
		return sign * res;
	}

	public static void main(String[] args) {
		StringtoInteger sol = new StringtoInteger();
		String str = "-1234567893649";
		System.out.println(sol.atoi(str));
	}
}