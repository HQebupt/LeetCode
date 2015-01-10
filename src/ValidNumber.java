//Great refference -- http://blog.csdn.net/fightforyourdream/article/details/12900751

public class ValidNumber {
    // Sol 1 : Regular Expression
    // 话说正则匹配的时间和空间复杂度是多少呢
    public boolean isNumber(String s) {
	String str = s.trim();
	String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
	return str.isEmpty() ? false : str.matches(regex);
    }

    // Sol 2: Time: O(n)  Space: O(n)
    public static boolean isNumber2(String s) {
	int i = 0;
	while (s.charAt(i) == ' ') { // 移除前导whitespace
	    i++;
	    if (i >= s.length()) {
		return false;
	    }
	}
	if (s.charAt(i) == '+' || s.charAt(i) == '-') { // 忽略符号位
	    i++;
	}
	int j = s.length() - 1;
	while (s.charAt(j) == ' ') { // 移除后缀whitespace
	    j--;
	}
	if (i <= j) {
	    s = s.substring(i, j + 1);
	} else {
	    return false;
	}

	int dot = -1; // 记录点的位置
	int ee = -1; // 记录e的位置
	for (i = 0; i < s.length(); i++) {
	    if (dot == -1 && s.charAt(i) == '.') {
		dot = i;
	    } else if (ee == -1 && s.charAt(i) == 'e') {
		ee = i;
		if (i + 1 < s.length()
			&& (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+')) {
		    i++;
		}
	    } else {
		if (Character.isDigit(s.charAt(i))) {
		    continue;
		} else {
		    return false;
		}
	    }
	}

	// xxx.xxexx
	String startStr, midStr, lastStr;
	if (dot == -1 && ee == -1) { // xxx
	    startStr = s; // xxx
	    if (startStr.length() < 1) {
		return false;
	    }
	} else if (dot != -1 && ee == -1) { // xxx.yyy
	    startStr = s.substring(0, dot); // xxx
	    midStr = s.substring(dot + 1); // yyy
	    if (startStr.length() < 1 && midStr.length() < 1) {
		return false;
	    }
	} else if (dot == -1 && ee != -1) { // xxxeyyy
	    startStr = s.substring(0, ee); // xxx
	    if (startStr.length() < 1) {
		return false;
	    }
	    if (ee + 1 < s.length()
		    && (s.charAt(ee + 1) == '-' || s.charAt(ee + 1) == '+')) { // xxxe-zz
		lastStr = s.substring(ee + 2); // zz
	    } else {
		lastStr = s.substring(ee + 1);
	    }
	    if (lastStr.length() < 1) {
		return false;
	    }
	} else { // xxx.yyezz
	    if (dot > ee) { // 位置不对
		return false;
	    }
	    startStr = s.substring(0, dot); // xxx
	    midStr = s.substring(dot + 1, ee); // yy
	    if (startStr.length() < 1 && midStr.length() < 1) {
		return false;
	    }
	    if (ee + 1 < s.length()
		    && (s.charAt(ee + 1) == '-' || s.charAt(ee + 1) == '+')) {
		lastStr = s.substring(ee + 2); // zz
	    } else {
		lastStr = s.substring(ee + 1);
	    }
	    if (lastStr.length() < 1) {
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	String s = " e10";
	ValidNumber sol = new ValidNumber();
	System.out.println(sol.isNumber(s));
    }
}