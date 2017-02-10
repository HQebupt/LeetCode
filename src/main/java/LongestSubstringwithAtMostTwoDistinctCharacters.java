import java.util.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	/**
	 * For example, Given s = “eceba”, T is "ece" which its length is 3.
	 * 
	 * 这题的线性解法是维护一个sliding
	 * window，里面的子字符串只含最多两个不同字符。当要添加一个新字符时，需要完全去掉之前的某一个字符的所有出现。这里有两个问题需要考虑：
	 * 
	 * 1）在已有的两个字符中，如何选择该去掉其所有出现的字符？
	 * 
	 * 2）在选定该去掉的字符后，如何改调整窗口？
	 * 
	 * 以“abac”为例，可以发现当扫描到c时，a是一定会被去掉的，但是如果去掉所有出现过的a，那么最后只剩下
	 * "c"了。这时应该是去掉所有出现的b，顺便去掉了最开始的a
	 * ，从而得到"ac"。由此观之，选择标准应该是字符的最后出现的位置，最后出现的位置越左（早）
	 * ，则其出现被全部删除后所减小的长度越少。因此，应该删光最后出现位置在最左的字符。
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int start = 0;
		int maxLen = 0;

		// Key: letter; value: the index of the last occurrence.
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (map.size() == 2 && (!map.containsKey(ch))) {
				Character needDelete = ' ';
				int needDeleteIndex = len;
				for (Character tmp : map.keySet()) {
					int last = map.get(tmp);
					if (last < needDeleteIndex) {
						needDeleteIndex = last;
						needDelete = tmp;
						start = last + 1;
					}
				}
				map.remove(needDelete);
			}
			map.put(ch, i);
			maxLen = Math.max(maxLen, i - start + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		LongestSubstringwithAtMostTwoDistinctCharacters sol = new LongestSubstringwithAtMostTwoDistinctCharacters();
		String s = "eeccecbc";
		System.out.println(sol.lengthOfLongestSubstringTwoDistinct(s));
	}
}
