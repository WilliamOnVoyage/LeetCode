package algorithm.sortAndsearh;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		for (int row = 0, col = matrix[row].length - 1; row < matrix.length && col >= 0;) {
			if (matrix[row][col] == target)
				return true;
			if (matrix[row][col] > target) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}
