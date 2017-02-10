//Time:O(n!) Space:O(n)
public class NQueensII {
	private int size;
	private int[] colsOccupied;
	private int[] cross1Occupied;
	private int[] cross2Occupied;
	private int count;

	private static final int STATUS_OCCUPIED = 1;
	private static final int STATUS_UNOCCUPIED = 0;

	public int totalNQueens(int n) {
		this.size = n;
		this.colsOccupied = new int[size];
		this.cross1Occupied = new int[size * 2];
		this.cross2Occupied = new int[size * 2];
		place(0);
		return this.count;
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
				setStatus(i, j, STATUS_OCCUPIED);
				if (i == size - 1)
					count++;
				else {
					place(i + 1);
				}
				setStatus(i, j, STATUS_UNOCCUPIED);
			}
		}
	}

	public static void main(String args[]) {
		NQueensII sol = new NQueensII();
		int n = 9;
		int res = sol.totalNQueens(n);
		System.out.println(res);
	}
}
