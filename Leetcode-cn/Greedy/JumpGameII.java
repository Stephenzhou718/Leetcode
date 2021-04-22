package Greedy;

/**
 * @Author: zhouhanming
 * @Date:2021/4/20 11:08 下午
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * 思路：
 * 1. 反向贪心
 *
 * 五毒神掌：
 * 第二遍，2021/4/21
 * 第三遍，2021/4/22
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int cnt = 0;
        int index = nums.length -1;
        while (index != 0) {
            int minIndex = index;
            cnt++;
            for (int i = index; i >= 0; i--) {
                if (i + nums[i] >= index) {
                    minIndex = i;
                }
            }
            index = minIndex;
        }

        return cnt;
    }
}
