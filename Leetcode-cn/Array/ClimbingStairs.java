package Array;

/**
 * @Author: zhouhanming
 * @Date:2021/3/3 10:41 下午
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 解法：
 * 1. 动态规划入门（用数组存下计算过的值）：时间复杂度 O(n);
 *
 * 五毒神掌：第三遍， 下一遍时间: 2021/3/11
 **/

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }

        return dp[n];
    }
}
