/**
 * @Author: zhouhanming
 * @Date:2020/8/13 10:14 下午
 * 有效的完全平方数
 */
public class ValidPerfectSquare_367 {
    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare_367().isPerfectSquare(2147483647));
    }
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;

        int left = 0, right = num;

        while (left <= right) {
            int mid =  left + (right - left) / 2;
            long square = (long)mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else if (square == num) {
                return true;
            }
        }
        return false;
    }
}
