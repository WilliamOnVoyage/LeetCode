
package algorithm.recursionDP;

import java.util.*;

public class MaxRectangle {
	public int largestRectangleArea(int[] heights) {
		int a = 0;
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i <= heights.length; i++) {
			int h = i == heights.length ? 0 : heights[i];
			if (s.isEmpty() || h >= heights[s.peek()]) {
				s.push(i);
			} else {
				int idx = s.pop();
				a = Math.max(a, heights[idx] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return a;
	}

	public int maximalRectangle(char[][] matrix) {
		/**
		 * idea: using [LC84 Largest Rectangle in Histogram]. For each row of
		 * the matrix, construct the histogram based on the current row and the
		 * previous histogram (up to the previous row), then compute the largest
		 * rectangle area using LC84.
		 */
		int m = matrix.length, n;
		if (m == 0 || (n = matrix[0].length) == 0)
			return 0;

		int i, j, res = 0;
		int[] heights = new int[n];
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (matrix[i][j] == '0')
					heights[j] = 0;
				else
					heights[j] += 1;
			}
			res = Math.max(res, largestRectangleArea(heights));
		}

		return res;
	}
}
