package offer;

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @date 2015-7-13
 */
public class Solution5 {
	/**
	 * 此题是字符串替换，没有什么特别。我的办法是多用了O(n)空间来分词，然后组合成结果。
	 * Time:O(n) Space：O(n)
	 * 《剑指offer》推荐的做法是字符串移动：
	 * 1.遍历一遍，找到空格的个数
	 * 2.预留最后的结果的大小，用2个指针来控制移动。
	 * 但是，这个不太适合用java来实现，java把字符串封装比较好。
	 */
	public String replaceSpace(String str) {
		final String asii = "%20";
		StringBuilder sb = new StringBuilder();
		String[] words = str.split("\\s", -1);
		for (String s : words) {
			sb.append(asii + s);
		}
		return sb.substring(3);
	}

	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		String str = "We are you";
		String res = sol.replaceSpace(str);
		System.out.println(res);
	}
}
