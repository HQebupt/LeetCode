import java.util.LinkedList;
import java.util.List;
/**
 * 本题是求N位元的格雷码。通过二进制数转格雷码的规律公式：
 * G：格雷码 B：二进制码  , G(n) = (B(n)>>1) XOR B(n)
 * 移位操作+异或运算
 *
 */
public class GrayCode {
	// for add operation, use LinkedList. Attention!!!
	// Time: O(2^n)  Space: O(n)
	public List<Integer> grayCode(int n) {
		List<Integer> list = new LinkedList<Integer>();
		int pow = (int) Math.pow(2, n);
		for (int binary = 0; binary < pow; binary++) {
			int grayCode = (binary >> 1) ^ binary;
			list.add(grayCode);
		}
		return list;
	}

	public static void main(String[] args) {
		GrayCode sol = new GrayCode();
		int n = 2;
		System.out.println(sol.grayCode(n));
	}

}
