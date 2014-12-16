import java.math.BigInteger;


public class UniquePathsI {
	// Sol 3: DFS + 缓存 ,可以用 m = 3, n = 2 走一遍
	int[][] f;

	public int uniquePaths3(int m, int n) {
		f = new int[m + 1][n + 1];
		return dfs(m, n);
	}

	private int dfs(int x, int y) {
		if (x < 1 || y < 1)
			return 0;// 数据非法，终止条件
		if (x == 1 && y == 1)
			return 1; // 回到起点，收敛条件
		return getOrUpdate(x - 1, y) + getOrUpdate(x, y - 1);
	}

	private int getOrUpdate(int x, int y) {
		if (f[x][y] > 0)
			return f[x][y];
		else
			return f[x][y] = dfs(x, y);
	}
	
	// Sol 4: 数学公式
	public int uniquePaths4(int m, int n) {
		return combination(m + n - 2, Math.min(m - 1, n - 1));
	}

	 int combination(int n, int k) {
		if (k == 0) return 1;
		if (k == 1) return n;
		long ret = factor(n, k);
		ret /= factor(k, k);
		return (int)ret;
	}

	 long factor(int n, int k) {
		long res = 1 ;
		for (int i = n; i > (n - k); i--){
			res *= i;
		}
		return res;
	}

	public static void main(String[] args) {
		UniquePathsI sol = new UniquePathsI();
		int m = 23;
		int n = 12;
		System.out.println(sol.uniquePaths3(m, n));
	}
}
