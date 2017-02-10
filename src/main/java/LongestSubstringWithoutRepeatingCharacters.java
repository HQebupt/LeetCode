import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	// HashMap + 左右滑动窗口的控制left&right
	// Time:O(n)  Space:O(26) == O(1)
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		int left = 0, maxStart = 0, maxLen = 0;
		
		for (int right = 0; right < len; right++) {
			char ch = s.charAt(right);
			if (dict.containsKey(ch) && dict.get(ch) >= left) {
				int local = right - left;
				if (local > maxLen) {
					maxLen = local;
					maxStart = left;
				}
				left = dict.get(ch) + 1;
			} else if (right == len - 1) {
				int local = right - left + 1;
				if (local > maxLen) {
					maxLen = local;
					maxStart = left;
				}
			}
			dict.put(ch, right);
		}
		// System.out.println(s.substring(maxStart, maxStart + maxLen));
		return maxLen;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();
		String s = "qpxrjxkltzyx";
		int res = sol.lengthOfLongestSubstring(s);
		System.out.println(res);
	}
}