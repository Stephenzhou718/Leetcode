package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/4/27 9:41 下午
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * 思路：
 * 可以先用分治实现出来，然后再把分治转换成 DP 递推
 * DP
 *
 * 五毒神掌：
 * 第二遍，2021/4/27
 * 第三遍，2021/6/22
 */
public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
