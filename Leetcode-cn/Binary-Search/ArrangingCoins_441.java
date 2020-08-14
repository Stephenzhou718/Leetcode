/**
 * @Author: zhouhanming
 * @Date:2020/8/14 11:37 下午
 * 排列硬币
 * https://leetcode-cn.com/problems/arranging-coins/
 */
public class ArrangingCoins_441 {
    public int arrangeCoins(int n) {
        if (n < 1) return n;

        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = ((long)(mid + 1) * mid) / 2;
            if (sum < (long)n) {
                left = mid + 1;
            } else if (sum > (long)n) {
                right = mid - 1;
            } else if (sum == (long)n) {
                return mid;
            }
        }
        return left - 1;
    }
}
