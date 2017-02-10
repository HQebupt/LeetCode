import java.util.HashMap;
import java.util.Map;

// Time: O(n) Space:O(n)
// reference:http://blog.csdn.net/ljiabin/article/details/42025037
public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		String sign = (numerator ^ denominator) < 0 ? "-" : "";
		long num = numerator;
		long den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
		Map<Long, Integer> remainder = new HashMap<Long, Integer>();
		int position = 0, repeat = -1;
		long partA = num / den;
		long mod = num % den;
		String str = new String();
		while (mod != 0) {
			long dec = mod * 10 / den;
			if (remainder.containsKey(mod)) {
				repeat = remainder.get(mod);
				break;
			} else {
				remainder.put(mod, position);
				str += dec;
				position++;
			}
			mod = mod * 10 % den;
		}
		
		// 是否有小数部分
		if (str.length() == 0) {
			return sign + partA;
		}
		
		// 处理是否有循环体
		String partB = null;
		if (repeat != -1) {
			partB = "." + str.substring(0, repeat);
			partB += "(" + str.substring(repeat, position) + ")";
		} else {
			partB = "." + str.toString();
		}
		return sign + partA + partB;
	}

	public static void main(String[] args) {
		FractionToRecurringDecimal sol = new FractionToRecurringDecimal();
		int num = 7;
		int den = -12;
		String res = sol.fractionToDecimal(num, den);
		System.out.println(res);
	}
}