/**
 * @Author: zhouhanming
 * @Date:2020/8/12 9:36 下午
 * x 的平方根
 */
public class SqrtFunction_69 {
    public static void main(String[] args) {
        System.out.println(new SqrtFunction_69().mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long)mid * mid;
            if (square < x) {
                left = mid + 1;
            } else if (square > x) {
                right = mid - 1;
            } else if (square == x) {
                return mid;
            }
        }
        return left - 1;
    }
}
