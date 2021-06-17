package BitOperation;

/**
 * @Author: zhouhanming
 * @Date:2021/5/26 8:46 上午
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * 思路：
 * 1. 记住位元算的几个公式
 * n & (n - 1) 消掉最低位的 1
 *
 * 五毒神掌：
 * 第二遍，2021/5/26
 * 第三遍，2021/6/16
 * 第四遍，2021/6/17
 */
public class NumberOf1Bits {
    // 1. 使用公式 n & (n - 1) 去掉最低位的 1
    // 时间复杂度 logn, 即求 n 的二进制有多少位
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    // 2. 循环判断 n 的二进制上的每一位是不是为 1
    // 时间复杂度 k， 这里的 k = 32
    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

}
