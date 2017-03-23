package algorithm;

public class UniquePath {
	private int[][] map;

	public int uniquePaths(int m, int n) {
		map = new int[m][n];
		map[0][0] = 1;
		return uniquePaths_dp(m - 1, n - 1);
	}

	private int uniquePaths_dp(int m, int n) {
		if (m < 0 || n < 0)
			return 0;
		if (map[m][n] == 0)
			map[m][n] = uniquePaths_dp(m - 1, n) + uniquePaths_dp(m, n - 1);
		return map[m][n];
	}
}
