package Greedy;

import java.util.Arrays;

/**
 * @Author: zhouhanming
 * @Date:2021/4/20 11:06 下午
 * https://leetcode-cn.com/problems/assign-cookies
 *
 * 思路：
 * 1. 贪心
 *
 * 五毒神掌：
 * 第二遍，2021/4/21
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int satisfyCount = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                satisfyCount++;
            } else {
                j++;
            }
        }

        return satisfyCount;
    }
}
