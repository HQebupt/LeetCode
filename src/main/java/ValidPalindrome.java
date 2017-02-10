public class ValidPalindrome {
	// Time:O(n) Space:O(1)
	public boolean isPalindrome(String s) {
		int len = s.length();
		for (int pre = 0, back = len - 1; pre < back;) {
			// find the pre letter.
			char chPre = s.charAt(pre);
			boolean isPre = Character.isLetterOrDigit(chPre);
			if (!isPre) {
				pre++;
				continue;
			}

			// find the back letter.
			char chBack = s.charAt(back);
			boolean isBack = Character.isLetterOrDigit(chBack);
			if (!isBack) {
				back--;
				continue;
			}

			// check if they equal or not.
			int sub = Math.abs(chPre - chBack);
			boolean equal = (sub == 0 || sub == 32) ? true : false;
			if (equal) {
				pre++;
				back--;
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome sol = new ValidPalindrome();
		String s = " 3?8044''0''tt08?3  ";
		System.out.println(sol.isPalindrome(s));
	}
}