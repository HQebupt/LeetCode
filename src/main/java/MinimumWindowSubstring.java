import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	// Solution 1:
	// brute force : O(n^2)
	public String minWindow0(String s, String t) {
		int slen = s.length();
		int tlen = t.length();
		Map<Character, Integer> tmap = new HashMap<Character, Integer>();
		for (int i = 0; i < tlen; i++) {
			tmap.put(t.charAt(i), i);
		}
		int ps = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < slen; i++) {
			char sch = s.charAt(i);
			if (tmap.containsKey(sch)) {
				for (int j = i + tlen; j <= slen; j++) {
					String sub = s.substring(i, j);
					if (isContain(sub, t)) {
						int local = j - i;
						if (min > local) {
							min = local;
							ps = i;
						}
						// System.out.println("sub:" + sub + " min :" + min);
						break;
					}
				}
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(ps, ps + min);
	}

	private boolean isContain(String s, String t) {
		Map<Character, Integer> smap = new HashMap<Character, Integer>();
		int slen = s.length();
		int tlen = t.length();
		for (int i = 0; i < slen; i++) {
			char ch = s.charAt(i);
			if (smap.containsKey(ch)) {
				smap.put(ch, smap.get(ch) + 1);
			} else {
				smap.put(ch, 1);
			}
		}
		for (int i = 0; i < tlen; i++) {
			char ch = t.charAt(i);
			if (!smap.containsKey(ch)) {
				return false;
			} else {
				smap.put(ch, smap.get(ch) - 1);
				if (smap.get(ch) == 0) {
					smap.remove(ch);
				}
			}
		}
		return true;
	}

	// Solution 2: http://www.cnblogs.com/TenosDoIt/p/3461301.html
	/**
	 * 可以利用两个指针扫描（两个指针分别为start，i），以S = “e b a d b a c c b”（忽略空格），T = “abc”为例：
	1. 初始化 start = i = 0
	2. i 逐渐往后扫描S直到窗口S[start…i]包含所有T的字符，此时i = 6（字符c的位置）
	3. 缩减窗口：此时我们注意到窗口并不是最小的，需要调整 start 来缩减窗口。缩减规则为：如果S[start]不在T中 或者 S[start]在T中但是删除后窗口依然可以包含T中的所有字符，那么start = start+1， 直到不满足上述两个缩减规则。缩减后i即为窗口的起始位置，此例中从e开始窗口中要依次删掉e、b、a、d，start最后等于4 ，那么得到一个窗口大小为6-4+1 = 3
	4. start = start+1(此时窗口肯定不会包含所有的T中的字符)，跳转到步骤2继续寻找下一个窗口。本例中还以找到一个窗口start = 5，i = 8，比上个窗口大，因此最终的最小窗口是S[4…6]
	 */
	public String minWindow1(String s, String t) {
		int slen = s.length();
		Map<Character, Integer> tmap = buildMap(t);
		int start = 0, minStart = Integer.MAX_VALUE, minLen = Integer.MAX_VALUE;
		Map<Character, Integer> smap = new HashMap<Character, Integer>();
		for (int i = 0; i < slen;) {
			char ch = s.charAt(i);
//			System.out.println("looop: " + i);
			if (tmap.containsKey(ch)) {
				tmap.put(ch, tmap.get(ch) - 1);
				if (tmap.get(ch) == 0) {
					tmap.remove(ch);
				}
				if (smap.containsKey(ch)) {
					smap.put(ch, smap.get(ch) + 1);
				} else {
					smap.put(ch, 1);
				}

				// 已经包含所有的T
				if (tmap.isEmpty()) {
					// 缩小windows
					// System.out.println("start before:" + start + " i:" + i);
					// System.out.println(smap);
					start = localMinWodows(buildMap(t), smap, s, start, i);
					// System.out.println("start: " + start);
					int local = i - start + 1;
					if (local < minLen) {
						minLen = local;
						minStart = start;
					}
					start++;
					i = start;
					tmap = buildMap(t);
					smap.clear();
					continue;
				} else {
					i++;
				}
			} else {
				if (smap.containsKey(ch)) {
					smap.put(ch, smap.get(ch) + 1);
				}
				i++;
			}
			// System.out.println("i:" + i + " tmap:" + tmap);
			// System.out.println("smap:" + smap);

		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,
				minStart + minLen);
	}

	/**
	 * 在子串中减小窗口，用规则来减小。
	 * @param tmap
	 * @param smap
	 * @param s 
	 * @param start 字符串s的start位置
	 * @param end 字符串s的end位置
	 * @return
	 */
	private int localMinWodows(Map<Character, Integer> tmap,
			Map<Character, Integer> smap, String s, int start, int end) {
		int ps = start;
		for (int i = start; i <= end; i++) {
			char ch = s.charAt(i);
			if (tmap.containsKey(ch)) {
				int count = smap.get(ch);
				if (count > tmap.get(ch)) {
					smap.put(ch, count - 1);
					ps++;
				} else {
					ps = i;
					break;
				}
			} else {
				ps++;
			}
		}
		return ps;
	}

	private Map<Character, Integer> buildMap(String t) {
		int tlen = t.length();
		Map<Character, Integer> tmap = new HashMap<Character, Integer>();
		for (int i = 0; i < tlen; i++) {
			char ch = t.charAt(i);
			if (tmap.containsKey(ch)) {
				tmap.put(ch, tmap.get(ch) + 1);
			} else {
				tmap.put(ch, 1);
			}
		}
		return tmap;
	}
	
	/**
	 * Solution 3: 维护字典
	 * 这方法很厉害，维护一个字典，这个整体的方法要总结一下。如果维护一个字典，太厉害了。
	 * 这种思路：同样是建立一个字典，然后维护一个窗口。一定要总结一下。
	 * @param S
	 * @param T
	 * @return
	 */
	public String minWindow(String s, String t) {
		int slen = s.length();
		int tlen = t.length();
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if (dict.containsKey(ch)) {
				dict.put(ch, dict.get(ch) + 1);
			} else {
				dict.put(ch, 1);
			}
		}
		
		// 窗口的表示用left & right
		int left = 0, minStart = 0, minLen = slen + 1, count = 0;
		for (int right = 0; right < slen; right++) {
			char ch = s.charAt(right);
			if (dict.containsKey(ch)) {
				dict.put(ch, dict.get(ch) - 1);
				if (dict.get(ch) >= 0) {
					count++;
				}
				// 窗口已经包含了所有的T字符
				while (count == tlen) {
					int local = right - left + 1;
					if (local < minLen) {
						minLen = local;
						minStart = left;
					}
					char lch = s.charAt(left);
					if (dict.containsKey(lch)) {
						dict.put(lch, dict.get(lch) + 1);
						if (dict.get(lch) <= 0) {
							// nothing
						} else {
							count--;
						}
					} 
					left++;
				}
			}
		}
		return minLen == slen + 1 ? "" : s.substring(minStart, minStart + minLen);
	}
	
	/**
	 * 完全模拟Substring with Concatenation of All Words -- LeetCode的思路
	 */
	public String minWindow3(String s, String t) {
		int slen = s.length();
		int tlen = t.length();
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if (dict.containsKey(ch)) {
				dict.put(ch, dict.get(ch) + 1);
			} else {
				dict.put(ch, 1);
			}
		}

		// 窗口的表示用left & right
		int left = 0, minStart = 0, minLen = slen + 1, count = 0;
		Map<Character, Integer> curMap = new HashMap<Character, Integer>();
		for (int right = 0; right < slen; right++) {
			char ch = s.charAt(right);
			if (dict.containsKey(ch)) {
				if (curMap.containsKey(ch)) {
					curMap.put(ch, curMap.get(ch) + 1);
				} else {
					curMap.put(ch, 1);
				}
				if (curMap.get(ch) <= dict.get(ch)) {
					count++;
				}
//				System.out.println("count:" + count + " curMap:" + curMap);
				while (count == tlen) {
					int local = right - left + 1;
					if (local < minLen) {
						minLen = local;
						minStart = left;
					}
					char lch = s.charAt(left);
					if (curMap.containsKey(lch)) {
						curMap.put(lch, curMap.get(lch) - 1);
						if (curMap.get(lch) >= dict.get(lch)) {
							// nothing
						} else {
							count--;
						}
					} 
					left++;
				}
			}
		}
		return minLen == slen + 1 ? "" : s.substring(minStart, minStart + minLen);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring sol = new MinimumWindowSubstring();
		String s = "ebadbaccb";
		String t = "abc";
		System.out.println(sol.minWindow3(s, t));
	}
}
