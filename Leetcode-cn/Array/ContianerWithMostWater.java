package Array;

/**
 * @Author: zhouhanming
 * @Date:2021/3/2 10:40 下午
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 解法：
 * 1. 循环嵌套：时间复杂度 O(n^2), 空间复杂度 O(1)
 * 2. 双指针： 时间复杂度 O(n), 空间复杂度 O(1)
 *
 * 五毒神掌：第二遍，下一遍时间 2021/3/3
 * 五毒神掌：第三遍，第四遍时间：2021/3/10
 * 五毒神掌：第四遍，第五遍时间：
 */
public class ContianerWithMostWater {

    // 双指针
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = height[i] < height[j] ?
                    Math.max(maxArea, (j -i) * height[i++]) :
                    Math.max(maxArea, (j - i) * height[j--] );
        }
        return maxArea;
    }

    // 暴力双层嵌套
    public int maxArea_2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            }
        }

        return maxArea;
    }
}
