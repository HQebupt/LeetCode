import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		String ip = "";
		dfs(s, 0, 0, ip, result);
		return result;
	}

	private void dfs(String s, int start, int step, String ip,
			List<String> result) {
		int len = s.length();
		// 找到合法解
		if (start == len && step == 4) {
			String ans = ip.substring(0, ip.length() - 1);
			result.add(ans);
			return;
		}

		// 剪枝
		if (len - start > (4 - step) * 3)
			return;
		if (len - start < 4 - step)
			return;

		int num = 0;
		for (int i = start; i < start + 3 && i < len; i++) {
			String sub = s.substring(i, i + 1);
			num = num * 10 + Integer.parseInt(sub);
			if (num <= 255) {
				ip += sub;
				dfs(s, i + 1, step + 1, ip + ".", result);
			}
			if(num == 0) // 允许1.0.11.1,不允许1.01.1.1
				break;
		}
	}

	public static void main(String[] args) {
		RestoreIPAddresses sol = new RestoreIPAddresses();
		String s = "255255035";
		List<String> res = sol.restoreIpAddresses(s);
		System.out.println(res);
	}
}
