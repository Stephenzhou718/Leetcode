package Array;

/**
 * @Author: zhouhanming
 * @Date:2021/3/3 9:31 下午
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * 思路：
 * 1. 开一个新数组，遍历：时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 类似于冒泡排序：时间复杂度 O(n^2), 空间复杂度 O(1)
 * 3. 双指针：时间复杂度 O(n), 空间复杂度 O(1)
 * 4. 插入排序：时间复杂度 O(n), 空间复杂度 O(1)
 *
 * 五毒神掌：第三遍，第四遍时间：2021/3/11
 */
public class MoveZeroes {

    // 双指针
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, j++, i);
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 冒泡排序
    public static void moveZeroes_2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; i++) {
                if (nums[j] == 0) {
                    swap(nums, j, j++);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
