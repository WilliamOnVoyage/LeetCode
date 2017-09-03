package algorithm;

import java.util.*;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		return checkRowCol(board) && checkMat(board);
	}

	private boolean checkRowCol(char[][] board) {
		int[][] row_map = new int[board.length][9];
		int[][] col_map = new int[board.length][9];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] != '.') {
					if (row_map[row][board[row][col] - ini] > 0 || col_map[col][board[row][col] - ini] > 0) {
						return false;
					}
					row_map[row][board[row][col] - ini]++;
					col_map[col][board[row][col] - ini]++;
				}
			}
		}
		return true;
	}

	private boolean checkMat(char[][] board) {
		for (int row = 0; row < board.length; row += 3) {
			for (int col = 0; col < board[row].length; col += 3) {
				int[] map = new int[9];
				for (int r = row; r < row + 3; r++) {
					for (int c = col; c < col + 3; c++) {
						if (board[r][c] != '.') {
							if (map[board[r][c] - ini] > 0)
								return false;
							map[board[r][c] - ini]++;
						}
					}
				}
			}
		}
		return true;
	}

	private final char ini = '1';
	private final char[] sets = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public void solveSudoku(char[][] board) {
		List<HashSet<Character>> row_map = new ArrayList<>(9);
		for (int i = 0; i < 9; i++) {
			row_map.add(new HashSet<Character>());
		}
		List<HashSet<Character>> col_map = new ArrayList<>(9);
		for (int i = 0; i < 9; i++) {
			col_map.add(new HashSet<Character>());
		}
		List<HashSet<Character>> mat_map = new ArrayList<>(9);
		for (int i = 0; i < 9; i++) {
			mat_map.add(new HashSet<Character>());
		}
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] >= '0') {
					int mat_index = (row / 3) * 3 + col / 3;
					row_map.get(row).add(board[row][col]);
					col_map.get(col).add(board[row][col]);
					mat_map.get(mat_index).add(board[row][col]);
				}
			}
		}
		fillSudoku(board, row_map, col_map, mat_map);
	}

	private boolean fillSudoku(char[][] board, List<HashSet<Character>> row_map, List<HashSet<Character>> col_map, List<HashSet<Character>> mat_map) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				int mat_index = (row / 3) * 3 + col / 3;
				if (board[row][col] == '.') {
					for (char i : sets) {
						if (!row_map.get(row).contains(i) && !col_map.get(col).contains(i) && !mat_map.get(mat_index).contains(i)) {
							board[row][col] = i;
							row_map.get(row).add(i);
							col_map.get(col).add(i);
							mat_map.get(mat_index).add(i);
							if (!fillSudoku(board, row_map, col_map, mat_map)) {
								board[row][col] = '.';
								row_map.get(row).remove(i);
								col_map.get(col).remove(i);
								mat_map.get(mat_index).remove(i);
							}
						}
					}
					if (board[row][col] == '.') {// fail to fill this cell
						return false;
					}
				}
			}
		}
		return true;
	}
	// Use array check instead of hashset to have faster speed
	// public void solveSudoku(char[][] board) {
	// if (board == null || board.length == 0)
	// return;
	// solve(board);
	// }
	//
	// public boolean solve(char[][] board) {
	// for (int i = 0; i < board.length; i++) {
	// for (int j = 0; j < board[0].length; j++) {
	// if (board[i][j] == '.') {
	// for (char c = '1'; c <= '9'; c++) {// trial. Try 1 through 9
	// if (isValid(board, i, j, c)) {
	// board[i][j] = c; // Put c for this cell
	//
	// if (solve(board))
	// return true; // If it's the solution return true
	// else
	// board[i][j] = '.'; // Otherwise go back
	// }
	// }
	//
	// return false;
	// }
	// }
	// }
	// return true;
	// }
	//
	// private boolean isValid(char[][] board, int row, int col, char c) {
	// for (int i = 0; i < 9; i++) {
	// if (board[i][col] != '.' && board[i][col] == c)
	// return false; // check row
	// if (board[row][i] != '.' && board[row][i] == c)
	// return false; // check column
	// if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
	// && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
	// return false; // check 3*3 block
	// }
	// return true;
	// }
}
