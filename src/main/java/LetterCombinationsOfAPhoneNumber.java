import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public static String[] KEYBOARDS = { " ", "", "abc", "def", "ghi", "jkl",
			"mno", "pqrs", "tuv", "wxyz" };

	// Time:O(3^n) Space:O(n)
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		int size = digits.length();
		dfs(digits, size, 0, "", result);
		return result;
	}

	private void dfs(String digits, int size, int cur, String path,
			List<String> result) {
		// 终止条件
		if (cur == size) {
			result.add(path);
			return;
		}
		
		char[] keys = KEYBOARDS[digits.charAt(cur) - '0'].toCharArray();
		for (char ch : keys) {
			dfs(digits, size, cur + 1, path + ch, result);
		}
	}
	
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
		String digits = "23";
		System.out.println(sol.letterCombinations(digits));
	}
}