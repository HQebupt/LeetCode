
// Time:O(n * m)  Space:O(1)
public class CountAndSay {
	public String countAndSay(int n) {
		if (n < 1) return null;
		String s = "1";
		int num = 1;
		for (int i = 0; i < n - 1; i++) {
			int len = s.length();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < len; j++) {
				if(j < len - 1 && s.charAt(j) == s.charAt(j + 1)){
					num++;
				}else{
					sb.append(num + "" + s.charAt(j));
					num = 1;
				}
			}
			s = sb.toString();
		}
		return s;
	}

	public static void main(String[] args) {
		CountAndSay sol = new CountAndSay();
		for (int i = 1; i < 10; i++)
			System.out.println(sol.countAndSay(i));
	}
}
