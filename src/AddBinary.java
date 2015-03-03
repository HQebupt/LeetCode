//Time:O(n);Space:O(n)
public class AddBinary {
	public String addBinary(String a, String b) {
		char[] ac = new StringBuilder(a).reverse().toString().toCharArray();
		char[] bc = new StringBuilder(b).reverse().toString().toCharArray();
		int alen = ac.length;
		int blen = bc.length;
		StringBuilder res = new StringBuilder();
		int max = alen > blen ? alen : blen;
		int carry = 0;
		for (int i = 0; i < max; i++) {
			int ai = i < alen ? ac[i] - '0' : 0;
			int bi = i < blen ? bc[i] - '0' : 0;
			int sum = ai + bi + carry;
			carry = sum / 2;
			res.append((char) (sum % 2 + '0'));
		}
		if (carry == 1)
			res.append('1');
		return res.reverse().toString();
	}
}