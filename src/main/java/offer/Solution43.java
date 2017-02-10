package offer;

public class Solution43 {
	/**
	 * 翻转单词顺序列
	 * 思路：利用分词split就好。
	 * Time：O(n) Space：O(n)
	 */
	public String reverseSentence(String s) {
		if(s.length() == 0) 
			return "";
		String[] tmp = s.split("\\s", -1); // -1 为了通过测试用例 Input:" " , Output:" "
		StringBuilder sb = new StringBuilder();
		int len = tmp.length;
		sb.append(tmp[len - 1]);
		for (int i = len - 2; i >= 0; i--) {
			sb.append(" " + tmp[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution43 sol = new Solution43();
		String s = " ";
		System.out.println(sol.reverseSentence(s) + "a");
	}
}
