import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	// Time:O(n)  Space:O(26) == O(1)
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len == 0) 
			return 0;
		int max = Integer.MIN_VALUE;
		Map<Character, Integer> alp = new HashMap<Character, Integer>(26);
		int p1 = 0;
		for (int i = 0; i < len - 1; i++) {
			char c = s.charAt(i);
			if (alp.containsKey(c) && (alp.get(c) >= p1)) {
				max = Math.max(max, i - p1);
				p1 = alp.get(c) + 1;
			}
			alp.put(c, i);
		}
		// 最后一个字符单独处理
		char c = s.charAt(len - 1);
		if (alp.containsKey(c) && (alp.get(c) >= p1)) {
			max = Math.max(max, len - 1 - p1);
		}else {
			max = Math.max(max, len - p1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();
		String s = "qpxrjxkltzyx";
		int res = sol.lengthOfLongestSubstring(s);
		System.out.println(res);
	}
}