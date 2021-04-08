package Recursive;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 10:28 下午
 * https://leetcode-cn.com/problems/combinations/
 * 思路：
 * 1. DFS，递归（这种排列组合 + 剪枝）: 时间复杂度 O(nk), 空间复杂度 O(n)
 *
 * 五毒神掌：
 * 第二遍, 2021/3/14
 * 第三遍, 2021/4/8
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combineCore(n, k, new ArrayList<>(), res);
        return res;
    }

    private void combineCore(int n, int k, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (cur.size() != 0 && i <= cur.get(cur.size() - 1)) {
                continue;
            }
            cur.add(i);
            combineCore(n, k, cur, res);
            cur.remove((cur.size() - 1));
        }
    }

    private void combineCore_2(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            combineCore_2(n, k - 1, start + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 只有这里 i <= n - (k - path.size()) + 1 与参考代码 1 不同
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
}
