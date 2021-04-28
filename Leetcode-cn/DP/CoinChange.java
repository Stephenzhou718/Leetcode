package DP;

import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/4/28 8:47 下午
 * https://leetcode-cn.com/problems/coin-change
 *
 * 思路：
 * 1. DP
 * 2. DFS
 *
 * 五毒神掌：
 * 第二遍， 2021/4/28
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }
}
