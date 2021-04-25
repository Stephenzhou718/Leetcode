package DFS_BFS;

/**
 * @Author: zhouhanming
 * @Date:2021/4/18 9:38 下午
 * https://leetcode-cn.com/problems/minesweeper/description
 *
 * 思路：
 *
 * 五毒神掌：
 * 第二遍：2021/4/19
 * 第三遍：2021/4/20
 */
public class Minesweeper {
    private int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    private int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        int count = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 'M') {
                count++;
            }
        }

        if (count > 0) {
            board[i][j] = (char) (count + '0');
            return;
        }

        board[i][j] = 'B';
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') {
                continue;
            }
            dfs(board, x, y);
        }
    }

}
