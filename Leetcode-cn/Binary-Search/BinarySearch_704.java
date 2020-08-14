/**
 * @Author: zhouhanming
 * @Date:2020/8/15 12:11 上午
 * 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 */
public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            if (midValue < target) {
                left = mid + 1;
            } else if (midValue > target) {
                right = mid - 1;
            } else if (midValue == target) {
                return mid;
            }
        }
        return -1;
    }
}

