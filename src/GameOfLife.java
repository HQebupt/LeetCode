import java.util.Arrays;

public class GameOfLife {
	// Solution 1：开辟了额外空间O(n), 来计算。
	public void gameOfLife1(int[][] board) {
		int m = board.length;
		int n = board[0].length;

		int[][] copy = new int[m][n];
		for (int i = 0; i < m; i++) {
			System.arraycopy(board[i], 0, copy[i], 0, n);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveCell = getLiveCell0(copy, i, j);
				if (board[i][j] == 1) {
					if (liveCell < 2 || liveCell > 3) {
						board[i][j] = 0;
					}
				} else {
					if (liveCell == 3) {
						board[i][j] = 1;
					}
				}
			}
		}
	}

	private int getLiveCell0(int[][] board, int i, int j) {
		int res = 0;
		int row = i - 1;
		int col = j - 1;
		for (int p = row; p < row + 3; p++) {
			for (int q = col; q < col + 3; q++) {
				if ((p >= 0 && p < board.length)
						&& (q >= 0 && q < board[0].length)) {
					res += board[p][q];
				}
			}
		}
		res = res - board[i][j];
		return res;
	}

	// Solution 2:借助变化的四个状态
	/**
	 * 状态0： 死细胞转为死细胞 DEAD_TO_DEAD
	 * 
	 * 状态1： 活细胞转为活细胞 LIVE_TO_LIVE
	 * 
	 * 状态2： 活细胞转为死细胞 LIVE_TO_DEAD
	 * 
	 * 状态3： 死细胞转为活细胞 DEAD_TO_LIVE
	 */

	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		final int LIVE_TO_DEAD = 2;
		final int DEAD_TO_LIVE = 3;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveCell = getLiveCell(board, i, j);
				if (board[i][j] == 1) {
					if (liveCell < 2 || liveCell > 3) {
						board[i][j] = LIVE_TO_DEAD;
					}
				} else {
					if (liveCell == 3) {
						board[i][j] = DEAD_TO_LIVE;
					}
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = board[i][j] % 2;
			}
		}
	}

	private int getLiveCell(int[][] board, int i, int j) {
		int count = 0;
		int row = i - 1;
		int col = j - 1;
		for (int p = row; p < row + 3; p++) {
			for (int q = col; q < col + 3; q++) {
				if ((p >= 0 && p < board.length)
						&& (q >= 0 && q < board[0].length)) {
					if (board[p][q] == 1 || board[p][q] == 2) {
						count++;
					}
				}
			}
		}
		count = count - board[i][j];
		return count;
	}

	public static void main(String[] args) {
		GameOfLife sol = new GameOfLife();
		int[][] board = { { 1, 0, 1, 1 }, { 0, 1, 1, 1 }, { 1, 0, 0, 0 },
				{ 0, 0, 1, 0 } };
		sol.gameOfLife(board);
		System.out.println("board:");
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
}