package offer;

public class Solution45 {
	/**
	 * 循环左移字符串 
	 * Time:O(n)  Space:O(n)
	 */
	public String leftRotateString(String s, int k) {
		int len = s.length();
		if(len == 0)
			return "";
		
		String tmp = s + s;
		k = k % len; // 防止k越界
		return tmp.substring(k, k + len);
	}
	
	public static void main(String[] args) {
		Solution45 sol = new Solution45();
		String s = "abcXYZdef";
		int k = 3;
		System.out.println(sol.leftRotateString(s, k));
	}

}
