import java.util.BitSet;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		int length = A.length;
		BitSet bs = new BitSet(length + 2);
		for (int i = 0; i < length; i++) {
			if (A[i] > 0) {
				bs.set(A[i]);
			}
		}
		int pos = 1;
		int len = bs.length();
		for (; pos < len; pos++) {
			if (bs.get(pos) == false) {
				break;
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		int[] A = { 1 };
		// int[] A = { 1, 2, 3, 4, 5, 6, 0, 8, 9, -1, -2, -3 };
		FirstMissingPositive sol = new FirstMissingPositive();
		System.out.println(sol.firstMissingPositive(A));
	}
}