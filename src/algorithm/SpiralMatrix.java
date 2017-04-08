package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> r = new ArrayList<>();
		if (matrix != null && matrix.length != 0) {
			int left = 0, top = 0;
			int right = matrix[0].length - 1, down = matrix.length - 1;
			while (left <= right && top <= down) {
				for (int j = left; j <= right; j++) {
					r.add(matrix[top][j]);
				}
				top++;
				for (int i = top; i <= down; i++) {
					r.add(matrix[i][right]);
				}
				right--;
				if (down >= top) {
					for (int j = right; j >= left; j--) {
						r.add(matrix[down][j]);
					}
					down--;
				}
				if (right >= left) {
					for (int i = down; i >= top; i--) {
						r.add(matrix[i][left]);
					}
					left++;
				}
			}
		}
		return r;
	}

	public static int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		int left = 0, top = 0;
		int right = n - 1, down = n - 1;
		int count = 1;
		while (left <= right) {
			for (int j = left; j <= right; j++) {
				ret[top][j] = count++;
			}
			top++;
			for (int i = top; i <= down; i++) {
				ret[i][right] = count++;
			}
			right--;
			for (int j = right; j >= left; j--) {
				ret[down][j] = count++;
			}
			down--;
			for (int i = down; i >= top; i--) {
				ret[i][left] = count++;
			}
			left++;
		}
		return ret;
	}
}
