package Recursive;

/**
 * @Author: zhouhanming
 * @Date:2021/3/17 8:59 下午
 * https://leetcode-cn.com/problems/powx-n/
 *
 * 思路：
 * 1. 暴力乘：时间复杂度O(n), 空间复杂度 O(1)
 * 2. 分治：时间复杂度 O(logn), 空间复杂度 O(logn)
 *
 * 五毒神掌：
 * 第二遍，2021/3/17
 * 第三遍，2021/4/17
 */
public class PowxN {

    public double myPow(double x, int n) {
        return n > 0 ? quickMul(x , n) : 1.0 / quickMul(x, -n);
    }

    private Double quickMul(double x, int n)  {
        if (n == 0) {
            return 1.0;
        }

        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
