
package algorithm.recursionDP;

public class PaintHouse {
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length < 2) {
			return 0;
		}
		for (int i = 1; i < costs.length; i++) {
			int min_c = Integer.MAX_VALUE;
			int sec_c = Integer.MAX_VALUE;
			for (int k = 0; k < costs[i].length; k++) {
				// costs[i][k] = ?;
			}
		}
		int n = costs.length - 1;
		int result = Integer.MAX_VALUE;
		for (int k = 0; k < costs[n].length; k++) {
			result = costs[n][k] < result ? costs[n][k] : result;
		}
		return result;
	}
}
