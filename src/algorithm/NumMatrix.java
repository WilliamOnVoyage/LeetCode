package algorithm;

import java.util.*;

public class NumMatrix {
	class Box {
		Index start;
		Index end;

		Box(Index s, Index e) {
			start = s;
			end = e;
		}

		@Override
		public boolean equals(Object o) {
			if (o == this)
				return true;
			if (!(o instanceof Box)) {
				return false;
			}

			Box b = (Box) o;
			return b.start.equals(this.start) && b.end.equals(this.end);
		}

		@Override
		public int hashCode() {
			int result = 17;
			result = 31 * result + start.hashCode();
			result = 31 * result + end.hashCode();
			return result;
		}
	}

	class Index implements Comparator<Index> {
		int row;
		int col;

		Index(int r, int c) {
			row = r;
			col = c;
		}

		@Override
		public boolean equals(Object o) {
			if (o == this)
				return true;
			if (!(o instanceof Index)) {
				return false;
			}
			Index i = (Index) o;
			return i.row == this.row && i.col == this.col;
		}

		@Override
		public int hashCode() {
			int result = 17;
			result = 31 * result + row;
			result = 31 * result + col;
			return result;
		}

		@Override
		public int compare(Index i1, Index i2) {
			if ((i1.row >= i2.row && i1.col > i2.col) || (i1.row > i2.row && i1.col >= i2.col))
				return 1;
			if ((i1.row <= i2.row && i1.col < i2.col) || (i1.row < i2.row && i1.col <= i2.col))
				return -1;
			if (i1.row == i2.row && i1.col == i2.col)
				return 0;
			return Integer.MIN_VALUE;
		}

		public boolean inRange(Box b) {
			int comp_st = compare(this, b.start);
			int comp_ed = compare(this, b.end);
			return (comp_st == 0 || comp_st == 1) && (comp_ed == -1 || comp_ed == 0);
		}
	}

	private int[][] mat;
	private HashMap<Box, Integer> map;

	public NumMatrix(int[][] matrix) {
		mat = matrix;
		map = new HashMap<>();
	}

	public void update(int row, int col, int val) {
		int prev = mat[row][col];
		mat[row][col] = val;
		int delta = val - prev;
		Index i = new Index(row, col);
		// Change every sum region in map including [row,col]
		for (Box b : map.keySet()) {
			System.out.printf("Update box: [%d,%d], [%d,%d]\n", b.start.row, b.start.col, b.end.row, b.end.col);
			if (i.inRange(b)) {
				map.put(b, map.get(b) + delta);
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		Box b = new Box(new Index(row1, col1), new Index(row2, col2));
		if (map.containsKey(b)) {
			sum = map.get(b);
		} else {
			for (int r = row1; r <= row2; r++) {
				for (int c = col1; c <= col2; c++) {
					sum += mat[r][c];
				}
			}
			map.put(b, sum);
		}
		return sum;
	}
}
