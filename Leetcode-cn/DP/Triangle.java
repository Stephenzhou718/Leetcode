package DP;

import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/4/28 8:46 下午
 * https://leetcode-cn.com/problems/triangle/
 *
 * 思路：
 * DP, 细心啊， md
 *
 * 五毒神掌：
 * 第二遍，2021/4/28
 * 第三遍，2021/6/22
 *
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }

        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
