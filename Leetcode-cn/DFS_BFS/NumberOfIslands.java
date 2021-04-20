package DFS_BFS;

/**
 * @Author: zhouhanming
 * @Date:2021/4/18 9:37 下午
 * https://leetcode-cn.com/problems/number-of-islands
 *
 * 思路：
 * 1. BFS
 * 2. DFS
 *
 * 五毒神掌：
 * 第二遍，2021/4/19
 * 第三遍，2021/4/20
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
