<<<<<<< HEAD
package algorithm.recursionDP;

import java.util.*;

public class NQueen {
	public List<List<String>> solveNQueens(int n) {
		int[][] map = new int[n][n];
		List<List<String>> r = new ArrayList<>();
		solveNQueen_bp(r, new ArrayList<>(), map, 0);
		return r;
	}

	private int count;

	public int totalNQueens(int n) {
		count = 0;
		int[][] map = new int[n][n];
		solveNQueen_bp(map, 0);
		return count;
	}

	private void solveNQueen_bp(int[][] map, int row) {
		if (row == map.length) {
			count++;
			return;
		}
		for (int col = 0; col < map.length; col++) {
			if (map[row][col] == 0) {
				updatemap(map, row, col);
				solveNQueen_bp(map, row + 1);
				reverse_updatemap(map, row, col);
			}
		}
	}

	private void solveNQueen_bp(List<List<String>> r, List<String> list, int[][] map, int row) {
		if (list.size() == map.length) {
			r.add(new ArrayList<>(list));
			return;
		}
		for (int col = 0; col < map.length; col++) {
			if (map[row][col] == 0) {
				char[] line = new char[map.length];
				Arrays.fill(line, '.');
				line[col] = 'Q';
				list.add(new String(line));
				updatemap(map, row, col);
				solveNQueen_bp(r, list, map, row + 1);
				list.remove(list.size() - 1);
				reverse_updatemap(map, row, col);
			}
		}
	}

	private void updatemap(int[][] map, int row, int col) {
		for (int i = row; i < map.length; i++) {
			for (int j = 0; j < map[row].length; j++) {
				if (i == row || j == col || j - col == i - row || j - col == row - i) {
					map[i][j]++;
				}
			}
		}
	}

	private void reverse_updatemap(int[][] map, int row, int col) {
		for (int i = row; i < map.length; i++) {
			for (int j = 0; j < map[row].length; j++) {
				if (i == row || j == col || j - col == i - row || j - col == row - i) {
					map[i][j]--;
				}
			}
		}
	}
}
=======
package algorithm.recursionDP;

import java.util.*;

public class NQueen {
	public List<List<String>> solveNQueens(int n) {
		int[][] map = new int[n][n];
		List<List<String>> r = new ArrayList<>();
		solveNQueen_bp(r, new ArrayList<>(), map, 0);
		return r;
	}

	private int count;

	public int totalNQueens(int n) {
		count = 0;
		int[][] map = new int[n][n];
		solveNQueen_bp(map, 0);
		return count;
	}

	private void solveNQueen_bp(int[][] map, int row) {
		if (row == map.length) {
			count++;
			return;
		}
		for (int col = 0; col < map.length; col++) {
			if (map[row][col] == 0) {
				updatemap(map, row, col);
				solveNQueen_bp(map, row + 1);
				reverse_updatemap(map, row, col);
			}
		}
	}

	private void solveNQueen_bp(List<List<String>> r, List<String> list, int[][] map, int row) {
		if (list.size() == map.length) {
			r.add(new ArrayList<>(list));
			return;
		}
		for (int col = 0; col < map.length; col++) {
			if (map[row][col] == 0) {
				char[] line = new char[map.length];
				Arrays.fill(line, '.');
				line[col] = 'Q';
				list.add(new String(line));
				updatemap(map, row, col);
				solveNQueen_bp(r, list, map, row + 1);
				list.remove(list.size() - 1);
				reverse_updatemap(map, row, col);
			}
		}
	}

	private void updatemap(int[][] map, int row, int col) {
		for (int i = row; i < map.length; i++) {
			for (int j = 0; j < map[row].length; j++) {
				if (i == row || j == col || j - col == i - row || j - col == row - i) {
					map[i][j]++;
				}
			}
		}
	}

	private void reverse_updatemap(int[][] map, int row, int col) {
		for (int i = row; i < map.length; i++) {
			for (int j = 0; j < map[row].length; j++) {
				if (i == row || j == col || j - col == i - row || j - col == row - i) {
					map[i][j]--;
				}
			}
		}
	}
}
>>>>>>> branch 'master' of https://github.com/WilliamOnVoyage/LeetCode.git
