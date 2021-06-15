package Sort;

/**
 * @Author: zhouhanming
 * @Date:2021/5/27 10:59 下午
 * https://leetcode-cn.com/problems/reverse-pairs/
 *
 * 五毒神掌：
 * 第二遍，2021/5/27
 * 第三遍，2021/5/28
 * 第四遍，2021/6/15
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        return reversePairdRecursive(nums, 0, nums.length - 1);
    }

    public int reversePairdRecursive(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        // 统计下标对的数量
        int mid = (left + right) / 2;
        int ret = reversePairdRecursive(nums, left, mid) + reversePairdRecursive(nums, mid + 1, right);

        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) j++;
            ret += j - mid - 1;
        }

        // 随后合并两个排序数组
        int[] sorted = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            sorted[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) sorted[k++] = nums[i++];
        while (j <= right) sorted[k++] = nums[j++];

        System.arraycopy(sorted, 0, nums, left, right - left + 1);
        return ret;
    }
}
