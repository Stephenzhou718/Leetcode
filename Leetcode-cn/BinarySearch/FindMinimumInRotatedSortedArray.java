package BinarySearch;

/**
 * @Author: zhouhanming
 * @Date:2021/4/21 10:19 下午
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * 思路：
 * 二分法
 *
 * 第二遍，2021/4/25
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
