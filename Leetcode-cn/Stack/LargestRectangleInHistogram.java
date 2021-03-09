package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zhouhanming
 * @Date:2021/3/7 8:37 下午
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * 思路：
 * 1. 暴力三层循环：时间复杂度 O(n), 空间复杂度 O(1)
 * 2. 单调栈（https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/）：
 *
 * 五毒神掌：第二遍，第三遍时间 2021/3/8
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int res  = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeight = new int[heights.length + 2];

        for (int i = 1; i < heights.length + 1; i++) {
            newHeight[i] = heights[i - 1];
        }

        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                int cur = stack.pop();
                int left = stack.peek();
                int right = i;
                res = Math.max(res, (right - left - 1) * newHeight[cur]);
            }
            stack.push(i);
        }

        return res;
    }
}
