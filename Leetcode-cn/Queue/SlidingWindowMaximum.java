package Queue;

import java.util.*;

/**
 * @Author: zhouhanming
 * @Date:2021/3/7 10:53 下午
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 思路：
 * 1. 用 Queue 模拟数组：时间复杂度 O(n^2), 空间复杂度 O(k)
 * 2. 双端队列：时间复杂度 O(n), 空间复杂度 O(k)
 *
 * 五毒神掌：第二遍，第三遍时间 2021/3/8
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return nums;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);

            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }

            if (i >= k - 1) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }


}
