package BitOperation;

/**
 * @Author: zhouhanming
 * @Date:2021/5/26 8:55 上午
 * https://leetcode-cn.com/problems/counting-bits/description/
 *
 * 思路：
 *
 *
 * 五毒神掌：
 * 第二遍：2021/5/26
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
