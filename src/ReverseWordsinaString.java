import java.util.Arrays;

public class ReverseWordsinaString {

	/*
	 * Time:O(n) Space:O(n)
	 */
	public String reverseWords(String s) {
		String[] words = s.trim().split("\\s+");
		int size = words.length - 1;
		String res = words[size];
		for (int i = size - 1; i >= 0; i--) {
			res = res + " " + words[i];
		}
		return res;
	}

	/*
	 * 用数组来体会一下，另外一种思路。
	 */
	public void reverseWords1(char[] chs) {
		int len = chs.length;
		// 1.过滤掉前后多余的空格
		int left = 0, right = len - 1;
		for (int i = 0; i < len && (chs[i] == ' '); i++) {
			left++;
		}
		for (int i = len - 1; i >= 0 && (chs[i] == ' '); i--) {
			right--;
		}
		// System.out.println("left:"+ left + " right:" + right);

		// 2.过滤掉中间冗余的空格
		int newLen = right - left + 1;
		int index = 0;
		chs[index] = chs[left];
		for (int i = left + 1; i <= right; i++) {
			if (chs[i] == ' ' && chs[i] == chs[index]) {
				continue;
			} else {
				index++;
				chs[index] = chs[i];
				// System.out.println(chs[index]);
			}

		}
		// System.out.println("newString：" + Arrays.toString(chs));

		// 3.反转整个字符串，然后在反转其中的单词。
		reverse(chs, 0, newLen - 1);
		// System.out.println("newString：" + Arrays.toString(chs));
		// System.out.println("newLen:" + newLen);
		for (int i = 0, last = 0; i < newLen; i++) {
			if ( i == newLen || chs[i] == ' ') {
				reverse(chs, last, i - 1);
				last = i + 1;
			}
		}
		System.out.println("res:" + Arrays.toString(chs));
	}

	private void reverse(char[] chs, int left, int right) {
		while (left <= right) {
			swap(chs, left, right);
			left++;
			right--;
		}
	}

	private void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}

	public static void main(String[] args) {
		String s = " 01 2 3 4 ";
		ReverseWordsinaString sol = new ReverseWordsinaString();
		char[] chs = s.toCharArray();
		sol.reverseWords1(chs);

	}
}
/**
 * use split() method,clean up redundancy like "",and then reverse the words.
 * advanced point:regular expression "\\s+" can clean up redundancy blank.
 * attention:if input is "    ", the expect output is "". and the code is ok
 * because of split("\\s+").
 */
