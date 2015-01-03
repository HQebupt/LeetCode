public class LongestPalindromicSubstring {
	// Solution 3: DP
	// Time:O(n^2) Space:O(n^2)
	public String longestPalindrome(String s) {
		int len = s.length();
		boolean f[][] = new boolean[len][len];
		int max = 1, start = 0;
		for (int i = 0; i < len; i++) {
			f[i][i] = true;
			for (int j = 0; j < i; j++) {
				if (i - j == 1)
					f[j][i] = s.charAt(i) == s.charAt(j);
				else
					f[j][i] = (s.charAt(i) == s.charAt(j)) && (f[j + 1][i - 1]);
				if (f[j][i] && (max < i - j + 1)) {
					start = j;
					max = i - j + 1;
				}
			}
		}
		return s.substring(start, start + max);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
		String s = "a";
		System.out.println(sol.longestPalindrome(s));
	}
}