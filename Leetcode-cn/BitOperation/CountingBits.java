package BitOperation;

/**
 * @Author: zhouhanming
 * @Date:2021/5/26 8:55 上午
 * https://leetcode-cn.com/problems/counting-bits/description/
 *
 * 思路：
 * n & (n -1) 消掉最低的 1， 计算 1 的数量的时候，时间复杂度为 logn
 *
 * 五毒神掌：
 * 第二遍：2021/5/26
 * 第三遍：2021/6/16
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] bits = new int[n];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
