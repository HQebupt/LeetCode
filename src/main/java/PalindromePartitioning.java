import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 深搜：Time O(2^n) Space O(n)
// 动态规划 Time O(n^2) Space O(1)
public class PalindromePartitioning {
	
	// 深搜1
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		LinkedList<String> path = new LinkedList<String>();
		dfs(s, path, result, 0, 1);
		return result;
	}

	private void dfs(String s, LinkedList<String> path,	List<List<String>> result, int prev, int start) {
		if (start == s.length()) {
			if (isPalindrome(s, prev, start - 1)) {
				path.addLast(s.substring(prev, start));
				// System.out.println("path:"+path);
				result.add(new LinkedList<String>(path));
				path.removeLast();
			}
			return;
		}
		// 不断开
		dfs(s, path, result, prev, start + 1);
		// 断开
		if (isPalindrome(s, prev, start - 1)) {
			path.addLast(s.substring(prev, start));
			dfs(s, path, result, start, start + 1);
			path.removeLast();
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		char[] cs = s.toCharArray();
		while (start < end && cs[start] == cs[end]) {
			start++;
			end--;
		}
		return start >= end ? true : false;
	}
	
	
	// 深搜2
	public List<List<String>> partition2(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		LinkedList<String> path = new LinkedList<String>();
		dfs2(s, path, result, 0);
		return result;
	}

	private void dfs2(String s, LinkedList<String> path, List<List<String>> result, int start) {
		if (start == s.length()){
			result.add(new LinkedList<String>(path));
			return ; 
		}
		int len = s.length();
		for (int i = start; i < len; i++) {
			if (isPalindrome2(s, start, i)) {
				path.addLast(s.substring(start, i + 1));
				dfs2(s, path, result, i + 1);
				path.removeLast();
			}
		}
	}

	private boolean isPalindrome2(String s, int start, int end) {
		char[] cs = s.toCharArray();
		while (start < end && cs[start] == cs[end]) {
			start++;
			end--;
		}
		return start >= end ? true : false;
	}
	
	public static void main(String[] args) {
		PalindromePartitioning sol = new PalindromePartitioning();
		String s = "aabb";
		List<List<String>> res = sol.partition2(s);
		System.out.println(res);
	}
}