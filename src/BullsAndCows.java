public class BullsAndCows {
	/**
	 * 解决如下的输入用例
	 * @param secret 1122
	 * @param guess  1222
	 * @return       3A0B
	 */
	public String getHint(String secret, String guess) {
		int bulls = 0, cows = 0;
		int len = secret.length();
		int[] digits = new int[10];
		// 1.初始化HashTable，找正确的位置bulls
		for (int i = 0; i < len; i++) {
			int snum = secret.charAt(i) - '0';
			digits[snum] += 1;
			int gnum = guess.charAt(i) - '0';
			if (snum == gnum) {
				bulls++;
				digits[gnum]--;
			} 
		}
		
		// 2.找存在该数字，位置不正确的位置cows
		for (int i = 0; i < len; i++) {
			int snum = secret.charAt(i) - '0';
			int gnum = guess.charAt(i) - '0';
			if (snum != gnum && (digits[gnum] != 0)) {
				cows++;
				digits[gnum]--;
			} 
		}
		return bulls + "A" + cows + "B";
	}

	public static void main(String[] args) {
		BullsAndCows sol = new BullsAndCows();
		String secret = "1122";
		String guess = "1222";
		System.out.println(sol.getHint(secret, guess));
	}
}