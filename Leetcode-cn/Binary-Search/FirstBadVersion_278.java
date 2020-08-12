/**
 * @Author: zhouhanming
 * @Date:2020/8/12 10:14 下午
 */
public class FirstBadVersion_278 {

    boolean isBadVersion(int n) {
        return true;
    }

    public int firstBadVersion(int n) {
        if (n < 1) return -1;

        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // mid 在 target 右边
                right = mid - 1;
            } else if (!isBadVersion(mid)) {
                // mid 在 target 左边
                left = mid + 1;
            }
        }

        if (left > n || !isBadVersion(left)) {
            return -1;
        }
        return left;
    }
}
