import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	Queue<Integer> queue = new LinkedList<Integer>();

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int row = board.length;
		int col = board[0].length;
		// up row
		for (int i = 0; i < col; i++) {
			if (board[0][i] == 'O') {
				bfs(board, 0, i);
			}
		}

		// down row
		for (int i = 0; i < col; i++) {
			if (board[row - 1][i] == 'O') {
				bfs(board, row - 1, i);
			}
		}
		// left col
		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O') {
				bfs(board, i, 0);
			}
		}
		// right col
		for (int i = 0; i < row; i++) {
			if (board[i][col - 1] == 'O') {
				bfs(board, i, col - 1);
			}
		}

		// translate P and O
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'P')
					board[i][j] = 'O';
				else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void bfs(char[][] board, int i, int j) {
		fill(board, i, j);
		int row = board.length;
		int col = board[0].length;
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int x = curr / (col + row);
			int y = curr % (col + row);
			fill(board, x - 1, y);
			fill(board, x + 1, y);
			fill(board, x, y - 1);
			fill(board, x, y + 1);
		}
		// System.out.println("after bfs:");
		// print(board);
	}

	static void print(char[][] board) {
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void fill(char[][] board, int i, int j) {
		int row = board.length;
		int col = board[0].length;
		if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O')
			return;
		board[i][j] = 'P';
		queue.offer(i * (row + col) + j);
		// System.out.println(queue);
		// System.out.println("after fill:");
		// print(board);
	}

	public static void main(String[] args) {
		SurroundedRegions sol = new SurroundedRegions();
		// char[][] board = { { 'X', 'O', 'X', 'X' }, { 'X', 'X', 'O', 'X' },
		// { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' } };
		char[][] board = { { 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'X' } };
		System.out.println("init:");
		print(board);
		sol.solve(board);
		System.out.println("finally:");
		print(board);
	}
}