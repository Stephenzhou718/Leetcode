import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2020/8/17 11:14 下午
 * 找出给定方程的正整数解
 * https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/
 */
public class FindPositiveIntegerSolutionForAGivenEquation_1237 {

    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return 0;
        }
    };

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 1; i <= 1000; i++) {
            if (customfunction.f(i, 1) > z) {
                break;
            }
            int left = 1, right = 1000;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int value = customfunction.f(i, mid);
                if (value > z) {
                    right = mid - 1;
                } else if (value < z) {
                    left = mid + 1;
                } else if (value == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(mid);
                    ret.add(list);
                    break;
                }
            }
        }
        return ret;
    }
}
