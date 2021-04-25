package BinarySearch;

/**
 * @Author: zhouhanming
 * @Date:2021/4/21 10:17 下午
 * https://leetcode-cn.com/problems/sqrtx
 *
 * 思路：
 * 1. 二分法，时间复杂度，logn
 *
 * 五毒神掌：
 * 第二遍，2021/4/25
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long res = (long) mid * mid;

            if (res > x) {
                right = mid - 1;
            } else if (res < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }
}
