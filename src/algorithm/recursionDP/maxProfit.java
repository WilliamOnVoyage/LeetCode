package algorithm.recursionDP;

public class maxProfit {
	// Kadane algorithm
	public int getmaxProfit(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}
}
// HackerRank
/*
 * class Solution{ public int maxProfit(int k, int[] prices) { if (k>=prices.length/2){ int r = 0; for(int i = 1;i<prices.length;i++)
 * if(prices[i]>prices[i-1])r+=prices[i]-prices[i-1]; return r; }
 * 
 * int[][] dp = new int[k+1][prices.length]; for(int i = 1;i<=k;i++){ int maxCur = dp[i][0] - prices[0]; for(int j = 1;j<prices.length;j++){ dp[i][j] =
 * Math.max(dp[i][j-1],prices[j]+maxCur); maxCur = Math.max(maxCur,dp[i-1][j-1]-prices[j]); } } return dp[k][prices.length-1]; }
 * 
 * public static void main(String[] args){ Scanner sc = new Scanner(System.in); int k = sc.nextInt(); sc.nextLine(); String[] p_str = sc.nextLine().split(" ");
 * int[] prices = new int[p_str.length]; for(int i = 0;i<prices.length;i++){ prices[i] = Integer.valueOf(p_str[i]); }
 * 
 * Solution sol = new Solution(); int max = sol.maxProfit(k,prices); System.out.print(max); } }
 */
