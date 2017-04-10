package algorithm;

public class RotateMatrix {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		// Rotate 90 degree cc = flip + transpose
		for (int row = 0; row < n / 2; row++) {
			for (int col = 0; col < m; col++) {
				int temp = matrix[row][col];
				matrix[row][col] = matrix[n - 1 - row][col];
				matrix[n - 1 - row][col] = temp;
			}
		}

		for (int row = 0; row < n; row++) {
			for (int col = row; col < m; col++) {
				if (row != col) {
					int temp = matrix[row][col];
					matrix[row][col] = matrix[col][row];
					matrix[col][row] = temp;
				}
			}
		}
	}

}
