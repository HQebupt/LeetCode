import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
	/*
	 * String ,HashMap
	 * Time: O(n) Space:O(n)
	 * 
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		int slen = s.length();
		int wlen = words[0].length();
		List<Integer> res = new ArrayList<Integer>();
		Map<String, Integer> dict = new HashMap<String, Integer>();
		for (String word : words) {
			if (dict.containsKey(word)) {
				dict.put(word, dict.get(word) + 1);
			} else {
				dict.put(word, 1);
			}
		}

		int range = slen - wlen; 
		for (int i = 0; i < wlen; i++) {
			Map<String, Integer> curMap = new HashMap<String, Integer>();
			int left = i, count = 0;
			for (int j = i; j <= range; j += wlen) {
				String curStr = s.substring(j, j + wlen);
				if (dict.containsKey(curStr)) {
					if (curMap.containsKey(curStr)) {
						curMap.put(curStr, curMap.get(curStr) + 1);
					} else {
						curMap.put(curStr, 1);
					}
					if (curMap.get(curStr) <= dict.get(curStr)) {
						count++;
					} else { // todo
						while (true) {
							String tmp = s.substring(left, left + wlen);
							left += wlen;
							curMap.put(tmp, curMap.get(tmp) - 1);
							if (tmp.equals(curStr)) {
								break;
							} else {
								count--;
							}
						}
					}
				} else {
					curMap.clear();
					count = 0;
					left = j + wlen;
				}
				if (count == words.length) {
					res.add(left);
					String tmp = s.substring(left, left + wlen);
					curMap.put(tmp, curMap.get(tmp) - 1);
					left += wlen;
					count--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SubstringwithConcatenationofAllWords sol = new SubstringwithConcatenationofAllWords();
		String s = "barfoothefoobarman";
		String[] words = { "bar","foo"};
		System.out.println(sol.findSubstring(s, words));
	}
}