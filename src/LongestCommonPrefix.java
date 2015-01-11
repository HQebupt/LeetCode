public class LongestCommonPrefix {
	// Time:O(m*n) Space:O(1)
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int slen = strs[0].length();
		for (int index = 0; index < slen; index++) {
			for (int j = 1; j < strs.length; j++) {
				if (index >= strs[j].length()
						|| strs[j].charAt(index) != strs[0].charAt(index)) {
					return strs[0].substring(0, index);
				}
			}
		}
		return strs[0];
	}

	public static void main(String[] args) {
		LongestCommonPrefix sol = new LongestCommonPrefix();
		String[] strs = { "abacc", "ababa" };
		System.out.println(sol.longestCommonPrefix(strs));
	}
}