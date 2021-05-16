package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/5/16 4:10 下午
 * https://leetcode-cn.com/problems/palindromic-substrings
 *
 * 思路：1. 中心扩展法
 *
 * 五毒神掌：
 * 第二遍，2021/5/16
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt('j') && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
