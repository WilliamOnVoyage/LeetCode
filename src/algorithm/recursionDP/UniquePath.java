package algorithm.recursionDP;

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

	// Unique path with obstacles

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0)
			return 0;
		return uniquePaths_ob_dp(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[obstacleGrid.length - 1].length - 1);
	}

	private int uniquePaths_ob_dp(int[][] obstacleGrid, int m, int n) {
		if (m < 0 || n < 0 || obstacleGrid[m][n] == 1)
			return 0;
		if (map[m][n] == 0)
			map[m][n] = uniquePaths_ob_dp(obstacleGrid, m - 1, n) + uniquePaths_ob_dp(obstacleGrid, m, n - 1);
		return map[m][n];
	}
}
