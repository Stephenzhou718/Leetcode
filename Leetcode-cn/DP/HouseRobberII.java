package DP;

import java.util.Arrays;

/**
 * @Author: zhouhanming
 * @Date:2021/4/29 10:35 下午
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 * 思路：动态规划
 *
 * 五毒神掌：
 * 第二遍，2021/4/11
 * 第三遍，2021/6/23
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[length - 1];
    }
}
