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
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return true;
        }

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxs = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int num = ch - '0';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (rows[i][num] || cols[j][num] || boxs[boxIndex][num]) {
                        return false;
                    }

                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxs[boxIndex][num] = true;
                }
            }
        }
        return true;
    }
}
