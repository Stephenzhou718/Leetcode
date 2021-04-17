package Recursive;

/**
 * @Author: zhouhanming
 * @Date:2021/3/17 9:36 下午
 * https://leetcode-cn.com/problems/majority-element/
 *
 * 思路：
 * 1. hash 表，空间换时间：时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 排序，取中位数：时间复杂度 O(nlogn), 空间复杂度 O(logn) 的栈空间
 * 3. 分治：时间复杂度 （nlogn), 空间复杂度 （logn)
 *
 * 五毒神掌：
 * 第二遍，2021/3/17
 * 第三遍，2021/4/17
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = (hi -  lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int rifht = majorityElementRec(nums, mid + 1, hi);

        if (left == rifht) {
            return left;
        }

        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, rifht, lo, hi);

        return leftCount > rightCount ? left : rifht;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
