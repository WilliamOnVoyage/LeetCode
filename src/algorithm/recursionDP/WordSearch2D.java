package algorithm.recursionDP;

public class WordSearch2D {
	public boolean exist(char[][] board, String word) {
		if (board.length == 0)
			return false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (search(board, word, i, j, 0))
					return true;
			}
		}
		return false;
	}

	private boolean search(char[][] board, String word, int row, int col, int w_i) {
		if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] != word.charAt(w_i)) {
			return false;
		}
		if (w_i == word.length() - 1) {
			System.out.println(word.charAt(w_i));
			return true;
		}
		board[row][col] ^= 256;
		boolean found = search(board, word, row + 1, col, w_i + 1) || search(board, word, row - 1, col, w_i + 1) || search(board, word, row, col - 1, w_i + 1)
				|| search(board, word, row, col + 1, w_i + 1);
		board[row][col] ^= 256;
		return found;
	}
}
