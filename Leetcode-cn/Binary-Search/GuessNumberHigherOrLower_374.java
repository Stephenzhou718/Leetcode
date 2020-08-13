/**
 * @Author: zhouhanming
 * @Date:2020/8/13 10:34 下午
 *
 * 猜数字大小
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 */
public class GuessNumberHigherOrLower_374 {

    /**
     *
     * @param num
     * @return -1 if num is lower than the guess number
     *  *	   1 if num is higher than the guess number
     *  *      otherwise return 0
     */
    int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guessResult = guess(mid);
            if (guessResult == 1) {
                left = mid + 1;
            } else if (guessResult == -1) {
                right = mid - 1;
            } else if (guessResult == 0) {
                return mid;
            }
        }
        return -1;
    }
}
