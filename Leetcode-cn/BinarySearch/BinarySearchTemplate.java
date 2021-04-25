package BinarySearch;

/**
 * @Author: zhouhanming
 * @Date:2021/4/25 8:58 下午
 */
public class BinarySearchTemplate {

    /**
     * int left = 0;
     * int right = len(array) - 1;
     * while (left <= right) {
     *     mid = (left + right) / 2;
     *     if (array[mid] = target {
     *         find the target;
     *         break or return result
     *     } else if (array[mid] < target) {
     *         left = mid + 1;
     *     } else {
     *         right = mid - 1;
     *     }
     * }
     */

    public int template(int x) {

        int low = 0;
        int high = 0;

        // 二分的几种写法
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long result = mid * mid;
            if (result > x) {
                high = mid - 1;
            } else if (result < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low - 1;
    }
}
