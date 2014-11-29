//Time:O(n) Space:O(n) or O(1)
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = add(digits, 1);
		if (carry == 1) {
			int[] res = new int[digits.length + 1];
			res[0] = carry;
			for (int i = 0; i < digits.length; i++) {
				res[i+1] = digits[i];
			}
			return res;
		}
		return digits;
	}

	private int add(int[] digits, int num) {
		int len = digits.length;
		int carry = num;
		for (int i = len - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			carry = sum / 10;
			digits[i] = sum % 10;
		}
		return carry;
	}

	public static void main(String[] args) {
		int[] ds = { 9, 9, 9 };
		PlusOne sol = new PlusOne();
		ds = sol.plusOne(ds);
		System.out.println(ds[0]);
	}
}