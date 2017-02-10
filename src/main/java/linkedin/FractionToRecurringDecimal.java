package linkedin;

/**
 * leetcode 166  fraction to recurring decimal
 */

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		// sign + PartA + PartB
		if (numerator == 0)
			return "0";
		String sign = (numerator ^ denominator) < 0 ? "-" : "";
		long num = numerator;
		long den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
		Map<Long, Integer> remainder = new HashMap<Long, Integer>();

		long partA = num / den;
		long mod = num % den;
		int position = 0;
		int repeat = -1;
		String str = "";
		while (mod != 0) {
			long dec = mod * 10 / den;
			System.out.println(dec);
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
			partB = "." + str;
		}
		System.out.println("partB:"+ partB);
		return sign + partA + partB;
	}
	
	public static void main(String[] args) {
		FractionToRecurringDecimal sol = new FractionToRecurringDecimal();
		int num = -7;
		int den = 12;
		String res = sol.fractionToDecimal(num, den);
		System.out.println(res);
	}

}
