import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split("\\s", -1);
		int len = words.length;
		if (pattern.length() != len) {
			return false;
		}
		Map<Character, String> map = new HashMap<>(26);
		for (int i = 0; i < len; i++) {
			Character c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(words[i]))
					return false;
			} else {
				if (map.containsValue(words[i])) {
					return false;
				}
				map.put(c, words[i]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		WordPattern sol = new WordPattern();
		String pattern = "abba", str = "cat cat cat cat";
		System.out.println(sol.wordPattern(pattern, str));
	}
}