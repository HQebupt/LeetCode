public class DecodeWays {
	// 一维动态规划: Time O(n) Space O(n)
	/**
	 * 动态规划方程如下： 
	 * 
	 * 初始条件：dp[0] = 1, dp[1] = (s[0] == '0') ? 0 : 1 
	 * dp[i] = ( s[i-1] == 0 ? 0 : dp[i-1] ) + ( s[i-2,i-1]可以表示字母 ？ dp[i-2] : 0 )，
	 * 其中第一个分量是把s[0...i-1]末尾一个数字当做一个字母来考虑，第二个分量是把s[0...i-1]末尾两个数字当做一个字母来考虑
	 */
	public int numDecodings(String s) {
		// 1.初始化
		final int len = s.length();
		if (len == 0)
			return 0;
		int[] dp = new int[len + 1];
		dp[0] = 1;
		if (s.charAt(0) != '0')
			dp[1] = 1;
		else
			dp[1] = 0;

		// 2.一维DP方程
		for (int i = 2; i <= len; i++) {
			if (s.charAt(i - 1) != '0')
				dp[i] = dp[i - 1];
			else
				dp[i] = 0;
			if (s.charAt(i - 2) == '1'
					|| (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))
				dp[i] += dp[i - 2];
		}
		return dp[len];
	}
}