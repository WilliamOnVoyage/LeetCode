package algorithm;

public class GameofLife {
	class Tran {
		int ZERO_ZERO = 2;
		int ZERO_ONE = 3;
		int ONE_ZERO = 4;
		int ONE_ONE = 5;
	}

	private Tran t = new Tran();

	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				checkStats(board, row, col);
			}
		}
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				board[row][col] = convertStats(board[row][col]);
			}
		}
	}

	private void checkStats(int[][] board, int row, int col) {
		int live = countlive(board, row, col);
		if (islive(board[row][col])) {
			if (live < 2 || live > 3)
				board[row][col] = t.ONE_ZERO; // die
			else
				board[row][col] = t.ONE_ONE; // keep live
		} else {
			if (live == 3)
				board[row][col] = t.ZERO_ONE; // relive
		}
	}

	private int countlive(int[][] board, int row, int col) {
		int live = 0;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
					if (!(r == row && c == col)) {
						if (islive(board[r][c]))
							live++;
					}
				}
			}
		}
		return live;
	}

	private int convertStats(int n) {
		return (n == t.ONE_ONE || n == t.ZERO_ONE) ? 1 : 0;
	}

	private boolean islive(int n) {
		return n == 1 || n == t.ONE_ONE || n == t.ONE_ZERO;
	}
}
