package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/5/16 4:06 下午
 * https://leetcode-cn.com/problems/decode-ways/
 * 思路
 * 1. DFS: 取开头第一个字母，然后 Digg in  / 取开头两个字母，然后 digg in
 * 2. DP: 分为两种情况：当前字母不能和前面的字母组合 / 当前字母可以和前面的字母组合
 *
 * 五毒神掌：
 * 第二遍，2021/5/16
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        // 前面加个空格， 解决前导零的问题
        s = " " +  s;
        char[] cs = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // a: 代表「当前位置」单独形成 item
            // b: 代表「当前位置」与前一位置共同形成 item
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            // 如果 a 属于有效值，那么 f[1] 可以由 f[i - 1] 转移过来
            if (1 <= a && a <= 9) dp[i] = dp[i - 1];
            if (10 <= b && b <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
