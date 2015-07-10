public class RectangleArea {
	// 所求面积 = area1 + area2 - 重复区域的面积
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		// area1 area2
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);
		
		// overlaping
		int a = Math.min(D, H) < Math.max(B, F) ? 0 : Math.min(D, H) - Math.max(B, F);
		int b = Math.min(C, G) < Math.max(A, E) ? 0 :Math.min(C, G) - Math.max(A, E);
		return area1 + area2 - a * b;
	}
	
	public static void main (String[] args) {
		RectangleArea sol = new RectangleArea();
		// -1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1
		int res = sol.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1);
		System.out.println(res);
	}
	
	/**
	 * 改进前代码：
	 *  int a = Math.min(D, H) - Math.max(B, F);
		System.out.println(a);
		int b = Math.min(C, G) - Math.max(A, E);
		System.out.println(b); // 溢出
		a = a < 0 ? 0 : a;
		b = b < 0 ? 0 : b;
		
		问题：溢出
		测试用例：-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1
		
	 */
}