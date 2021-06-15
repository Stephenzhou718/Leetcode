package Sort;

/**
 * @Author: zhouhanming
 * @Date:2021/6/8 9:22 上午
 * https://leetcode-cn.com/problems/relative-sort-array/
 *
 * 思路：计数排序
 *
 * 五毒神掌：
 * 第二遍，2021/6/14
 * 第三遍，2021/6/15
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; i++) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }

        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }

        return ans;
    }
    
}
