package BinarySearch;

/**
 * @Author: zhouhanming
 * @Date:2021/4/21 10:18 下午
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 * 思路：
 * 1. 二分法
 *
 * 五毒神掌：
 * 第二遍，2021/4/25
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }

        return -1;
    }
}
