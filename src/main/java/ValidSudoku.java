/**
 * Reference:
 * http://blog.csdn.net/linhuanmars/article/details/20748171
 * 优化空间：http://www.cnblogs.com/TenosDoIt/p/3800485.html
 */

public class ValidSudoku {
    
    // Solution 1: 逐行、列、九宫格检查， hashTable
    // Time: O(3*n^2)  Space: O(n)
    public boolean isValidSudoku(char[][] board) {
	if (board == null || board.length != 9 || board[0].length != 9)
	    return false;
	
	// loop 1: each row
	for (int i = 0; i < 9; i++) {
	    boolean[] has = new boolean[9];
	    for (int j = 0; j < 9; j++) {
		if (board[i][j] != '.') {
		    final int row = board[i][j] - '1';
		    if (has[row]) {
			return false;
		    }
		    has[row] = true;
		}
	    }
	}

	// loop2: each column
	for (int j = 0; j < 9; j++) {
	    boolean[] has = new boolean[9];
	    for (int i = 0; i < 9; i++) {
		if (board[i][j] != '.') {
		    final int col = board[i][j] - '1';
		    if (has[col]) {
			return false;
		    }
		    has[col] = true;
		}
	    }
	}

	// loop3: sub 9 block
	for (int block = 0; block < 9; block++) {
	    boolean[] has = new boolean[9];
	    for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
		for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
		    if (board[i][j] != '.') {
			final int index = board[i][j] - '1';
			if (has[index]) {
			    return false;
			}
			has[index] = true;
		    }
		}
	    }
	}
	return true;
    }
}
