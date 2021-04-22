package Greedy;

/**
 * @Author: zhouhanming
 * @Date:2021/4/20 11:08 下午
 * https://leetcode-cn.com/problems/jump-game
 *
 * 思路：
 * 1. 贪心
 *
 * 五毒神掌：
 * 第二遍，2021/4/21
 * 第三遍，2021/4/22
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (farthest < i) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }
}
