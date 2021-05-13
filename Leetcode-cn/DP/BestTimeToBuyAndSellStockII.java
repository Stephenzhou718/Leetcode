package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/4/29 10:36 下午
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 思路：动态规划，股票问题可以用一个通解
 *
 * 五毒神掌：
 * 第二遍，2021/5/11
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        dp[0][0] =  0;
        dp[0][1] = -prices[0];

        // 从第二天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]-prices[i]);
        }

        return dp[len - 1][0];
    }
}
