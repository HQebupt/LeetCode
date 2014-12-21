import java.util.ArrayList;
import java.util.List;

//Time:O(n!) Space:O(n)
public class NQueens {
	private int size;
	private int[] colsOccupied;
	private int[] cross1Occupied;
	private int[] cross2Occupied;
	private int count;
	private int[] location;
	private List<String[]> res;

	private static final int STATUS_OCCUPIED = 1;
	private static final int STATUS_UNOCCUPIED = 0;

	public List<String[]> solveNQueens(int n) {
		this.size = n;
		this.colsOccupied = new int[size];
		this.cross1Occupied = new int[size * 2];
		this.cross2Occupied = new int[size * 2];
		this.location = new int[size];
		this.res = new ArrayList<String[]>();
		place(0);
		return this.res;
	}

	private boolean isOccupied(int i, int j) {
		return (colsOccupied[j] == STATUS_OCCUPIED)
				|| (cross1Occupied[i - j + size - 1] == STATUS_OCCUPIED)
				|| (cross2Occupied[i + j] == STATUS_OCCUPIED);
	}

	private void setStatus(int i, int j, int flag) {
		colsOccupied[j] = flag;
		cross1Occupied[i - j + size - 1] = flag;
		cross2Occupied[i + j] = flag;
	}

	private void place(int i) {
		for (int j = 0; j < size; j++) {
			if (!isOccupied(i, j)) {
				location[i] = j;
				setStatus(i, j, STATUS_OCCUPIED);
				if (i == size - 1) {
					count++;
					String[] ans = buildQueen(location);
					res.add(ans);
				} else {
					place(i + 1);
				}
				setStatus(i, j, STATUS_UNOCCUPIED);
			}
		}
	}

	private String[] buildQueen(int[] location) {
		String[] ans = new String[size];
		for (int k = 0; k < size; k++) {
			char[] qs = new char[size];
			for (int i = 0; i < size; i++) {
				if (i == location[k])
					qs[i] = 'Q';
				else
					qs[i] = '.';
			}
			ans[k] = new String(qs);
		}
		return ans;
	}

	public static void main(String args[]) {
		NQueens sol = new NQueens();
		int n = 8;
		List<String[]> res = sol.solveNQueens(n);
		System.out.println(res.size());
	}
}
