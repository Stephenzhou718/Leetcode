package BitOperation;

/**
 * @Author: zhouhanming
 * @Date:2021/5/26 8:54 上午
 * https://leetcode-cn.com/problems/reverse-bits/
 *
 * 思路：
 * 1. 每次循环去除一位移到对称的方向上去
 *
 * 五毒神掌：
 * 第二遍：2021/5/26
 * 第三遍：2021/6/14
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i <32; i++) {
            rev |= (n & 1) << (31 - i);
            n >>= 1;
        }
        return rev;
    }
}
