package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/4/28 8:46 下午
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 思路：
 * DP /  滚动数组？
 *
 * 五毒神掌：
 * 第二遍，2021/4/28
 * 第三遍，2021/6/22
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];

        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(pre, maxAns);
        }

        return maxAns;
    }
}
