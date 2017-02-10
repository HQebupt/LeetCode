package offer;

import java.util.HashMap;
import java.util.Map;

public class Solution41 {
	/*
	 * 第一个只出现一次的字符
	 * 思路：借助于HashMap，遍历2遍字符串，可以求得结果。
	 * Time:O(n)  Space:O(26)
	 */
	public int firstNotRepeatingChar(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>(26);
		int len = s.length();
		for(int i = 0; i < len; i++) {
			char c = s.charAt(i);
			this.count(map,c);
		}
		
		int resIndex = -1;
		for(int i = 0; i < len; i++) {
			if(map.get(s.charAt(i)) == 1){
				resIndex = i;
				break;
			}
		}
        return resIndex;
    }

	private void count(Map<Character, Integer> map, Character c) {
		if(map.containsKey(c)) {
			int count = map.get(c) + 1;
			map.put(c, count);
		} else {
			map.put(c, 1);
		}
	}
}
