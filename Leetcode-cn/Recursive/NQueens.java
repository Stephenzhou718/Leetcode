package Recursive;

import java.util.*;

/**
 * @Author: zhouhanming
 * @Date:2021/3/17 10:30 下午
 * https://leetcode-cn.com/problems/n-queens/
 *
 * 思路：
 * 1. 直接回溯：时间复杂度 O(n!), 空间复杂度 O(n)
 *
 * 五毒神掌：
 * 第二遍，2021/3/17
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> disgonals1 = new HashSet<>();
        Set<Integer> disgonals2 = new HashSet<>();
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        dfs(queue, 0, n, cols, disgonals1, disgonals2, res);
        return res;
    }

    private void dfs(int[] queue, int row, int n, Set<Integer> cols, Set<Integer> disgonals1, Set<Integer> disgonals2, List<List<String>> res) {
        if (row == queue.length) {
            res.add(genrateBoard(queue, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || disgonals1.contains(row + i) || disgonals2.contains(row - i)) {
                continue;
            }

            queue[row] = i;
            cols.add(i);
            disgonals1.add(row + i);
            disgonals2.add(row - i);
            dfs(queue, row + 1, n, cols, disgonals1, disgonals2, res);
            queue[row] = -1;
            cols.remove(i);
            disgonals1.remove(row + i);
            disgonals2.remove(row - i);
        }

    }

    private List<String> genrateBoard(int[] queue, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queue[i]] = 'Q';
            board.add(new String(row));
        }

        return board;
    }
}
