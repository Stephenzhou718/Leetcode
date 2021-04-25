package BinarySearch;

/**
 * @Author: zhouhanming
 * @Date:2021/4/21 10:18 下午
 * https://leetcode-cn.com/problems/valid-perfect-square
 *
 * 思路：
 * 1. 二分法
 *
 * 五毒神掌：
 * 第二遍，2021/4/25
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int left = 2;
        int right = num / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long res = (long) mid * mid;
            if (res > num) {
                right = mid - 1;
            } else if (res < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
