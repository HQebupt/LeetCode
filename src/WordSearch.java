public class WordSearch {
    // Time: O(m^2 * n^2)  Space:O(n^2)
    public boolean exist(char[][] board, String word) {
	int row = board.length;
	int cross = board[0].length;
	boolean[][] visited = new boolean[row][cross];
	for (int i = 0; i < row; i++)
	    for (int j = 0; j < cross; j++) {
		if (dfs(board, word, 0, i, j, visited))
		    return true;
	    }
	return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j,
	    boolean[][] visited) {
	if (index == word.length())
	    return true;
	int row = board.length;
	int cross = board[0].length;
	if (i < 0 || j < 0 || i == row || j == cross || visited[i][j] == true)
	    return false;
	if (word.charAt(index) != board[i][j])
	    return false;
	visited[i][j] = true;
	boolean find = dfs(board, word, index + 1, i - 1, j, visited)
		|| dfs(board, word, index + 1, i + 1, j, visited)
		|| dfs(board, word, index + 1, i, j - 1, visited)
		|| dfs(board, word, index + 1, i, j + 1, visited);
	visited[i][j] = false;
	return find;
    }

    public static void main(String[] args) {
	char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
		{ 'A', 'D', 'E', 'E' } };
	String word = "ABCCEDA";
	WordSearch sol = new WordSearch();
	boolean flag = sol.exist(board, word);
	System.out.println(flag);
    }
}