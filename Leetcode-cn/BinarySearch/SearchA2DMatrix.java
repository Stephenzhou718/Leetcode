package BinarySearch;

/**
 * @Author: zhouhanming
 * @Date:2021/4/21 10:19 下午
 * https://leetcode-cn.com/problems/search-a-2d-matrix
 *
 * 思路：
 * 1. 二分法
 *
 * 五毒神掌：
 * 第二遍，2021/4/25
 */

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int begin = 0;
        int end = rows * cols - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return false;
    }
}
