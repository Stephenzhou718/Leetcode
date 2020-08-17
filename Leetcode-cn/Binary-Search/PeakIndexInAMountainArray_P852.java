/**
 * @Author: zhouhanming
 * @Date:2020/8/16 11:41 下午
 * 山脉数组的峰顶索引
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInAMountainArray_P852 {
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return A[0];
        }

        int left = 0, right = A.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid] + 1) {
                left = mid + 1;
            } else if (A[mid] > A[mid] + 1) {
                right = mid - 1;
            } else if (A[mid] == A[mid] + 1) {
                right = mid - 1;
            }
        }
        if (left == A.length - 1) {
            return left - 1;
        }
        return left;
    }
}
