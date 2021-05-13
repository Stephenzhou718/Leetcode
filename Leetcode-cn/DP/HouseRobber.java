package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/4/29 10:34 下午
 * https://leetcode-cn.com/problems/house-robber/
 *
 * 思路：动态规划
 *
 * 第二遍：2021/4/11
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[length - 1];
    }
}
