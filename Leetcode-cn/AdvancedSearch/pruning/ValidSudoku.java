package AdvancedSearch.pruning;

/**
 * @Author: zhouhanming
 * @Date:2021/5/22 9:39 下午
 * https://leetcode-cn.com/problems/valid-sudoku
 *
 * 思路：
 * 1. 一次遍历（难点：建模子数独, (i / 3) * 3 + j / 3）
 *
 * 五毒神掌：
 * 第二遍，2021/5/22
 * 第三遍，2021/5/24
 * 第四遍，2021/6/19
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxs = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';

                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (rows[i][num] || cols[j][num] || boxs[boxIndex][num]) {
                        return false;
                    }

                    rows[i][num] = cols[j][num] = boxs[boxIndex][num] = true;
                }
            }
        }

        return true;
    }
}
