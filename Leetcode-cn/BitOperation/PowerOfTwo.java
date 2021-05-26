package BitOperation;

/**
 * @Author: zhouhanming
 * @Date:2021/5/26 8:50 上午
 * https://leetcode-cn.com/problems/power-of-two/
 *
 * 思路：
 * 1. 位运算的公式 n & (n - 1) 可以去掉最低位的 1
 * 2. 判断 n 的二进制的 1 的个数是否为 1
 *
 * 五毒神掌：
 * 第二遍：2021/5/26
 */
public class PowerOfTwo {

    // 1. n & (n - 1) 可以去掉最低位的 1
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

    // 2. n & (-n) 可以获取到最低位的 1
    public boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        long x = n;
        return (x & (-x)) == x;
    }
}
