package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/4/28 8:46 下午
 * https://leetcode-cn.com/problems/maximum-product-subarray
 *
 * 思路：
 * 1. DP, 双 DP 数组是我没想到的
 *
 * 五毒神掌：
 * 第二遍，2021/4/28
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];
        int ans = nums[0];

        maxF[0] = nums[0];
        minF[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(minF[i - 1] * nums[i], nums[i]));
            minF[i] = Math.min(maxF[i - 1] * nums[i], Math.min(minF[i - 1] * nums[i], nums[i]));
            ans = Math.max(ans, maxF[i]);
        }

        return ans;
    }

    public int maxProduct2(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            minF = Math.min(mx * nums[i], Math.min(mn * nums[i], nums[i]));
            ans =  Math.max(ans, maxF);
        }

        return ans;
    }
}
