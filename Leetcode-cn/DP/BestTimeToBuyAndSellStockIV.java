package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/4/29 10:38 下午
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * 思路：
 * 1. 如果 k > price.length / 2, 那么就可以认为 k 为无穷大
 * 2. 否则，则按买卖股票 III 来看
 *
 * 五毒神掌：
 * 第二遍，2021/5/13
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k ,int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        if (k > length / 2) {
            return maxProfit(prices);
        }

        int[][][] dp = new int[length][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < length; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[length - 1][k][0];
    }

    private int maxProfit(int[] price) {
        if (price == null || price.length == 0) {
            return 0;
        }

        int length = price.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -price[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + price[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price[i]);
        }

        return dp[length - 1][0];
    }

}
