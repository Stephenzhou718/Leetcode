package Greedy;

/**
 * @Author: zhouhanming
 * @Date:2021/4/20 11:06 下午
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 思路：
 * 1. 贪心算法
 *
 * 五毒神掌：
 * 第二遍：2021/4/21
 * 第三遍：2021/4/22
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            profit += Math.max(0, prices[i + 1] - prices[i]);
        }

        return profit;
    }
}
