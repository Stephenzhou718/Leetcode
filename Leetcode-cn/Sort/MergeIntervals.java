package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/6/8 9:23 上午
 * https://leetcode-cn.com/problems/merge-intervals
 *
 * 五毒神掌：
 * 第二遍，2021/6/14
 * 第三遍，2021/6/15
 * 第四遍，2021/6/21
 *
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length;) {
            int j = i + 1;
            int t = intervals[i][1];
            while (j < intervals.length && t >= intervals[j][0]) {
                t = Math.max(t, intervals[j][1]);
                j++;
            }
            res.add(new int[]{intervals[i][0], t});
            i = j;
        }

        return res.toArray(new int[res.size()][]);
    }
}
