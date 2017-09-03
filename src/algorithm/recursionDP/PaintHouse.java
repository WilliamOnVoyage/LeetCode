package algorithm.recursionDP;

public class PaintHouse {
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length < 2) {
			return 0;
		}
		int n = costs.length - 1, minCost = Integer.MAX_VALUE;
		for (int k = 0; k < costs[n].length; k++) {
			minCost = costs[n][k] < minCost ? costs[n][k] : minCost;
		}
		return minCost;
	}
}