package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/5/16 4:07 下午
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * 思路：
 * 1. DP， 找到 DP[i] 状态的定位，定义为边长
 *
 * 五毒神掌：
 * 第二遍，2021/5/16
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height + 1][width + 1];
        int maxSide = 0;

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }

        return maxSide * maxSide;
    }
}
