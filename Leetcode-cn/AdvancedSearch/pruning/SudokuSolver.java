package AdvancedSearch.pruning;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/5/22 10:11 下午
 * https://leetcode-cn.com/problems/sudoku-solver/
 *
 * 解题思路：
 * 1. DFS + 剪枝
 *
 * 五毒神掌：
 * 第二遍，2021/5/22
 * 第三遍，2021/5/24
 */
public class SudokuSolver {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] boxs = new boolean[9][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        if (board.length != 9 && board[0].length != 9) {
            return;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rows[i][num] = cols[j][num] = boxs[boxIndex][num] = true;
                }
            }
        }

        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int row = space[0];
        int col = space[1];
        int boxIndex = (row / 3) * 3 + col / 3;
        for (int i = 0; i < 9 && !valid; i++) {
            if (!rows[row][i] && !cols[col][i] && !boxs[boxIndex][i]) {
                rows[row][i] = cols[col][i] = boxs[boxIndex][i] = true;
                board[row][col] = (char) (i + '0' + 1);
                dfs(board, pos + 1);
                rows[row][i] = cols[col][i] = boxs[boxIndex][i] = false;
            }
        }
    }
}
