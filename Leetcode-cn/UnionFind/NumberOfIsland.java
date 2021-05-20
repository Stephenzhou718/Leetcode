package UnionFind;

/**
 * @Author: zhouhanming
 * @Date:2021/5/18 11:31 下午
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * 思路：
 * 1. DFS
 * 2. BFS
 * 3. 并查集
 *
 * 五毒神掌：
 * 第二遍：2021/5/18
 * 第三遍，2021/5/20
 *
 */
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * cols + j, (i - 1) * cols + j);
                    }
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        unionFind.union(i * cols + j, (i + 1) * cols + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * cols + j, i * cols + j - 1);
                    }
                    if (j + 1 < cols && grid[i][j + 1] == '1') {
                        unionFind.union(i * cols + j, i * cols + j +1);
                    }
                }
            }
        }
        return unionFind.count;
    }

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;

            parent = new int[m * n];
            rank = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                }
            }
        }

        private int find(int n) {
            while (n != parent[n]) n = parent[n];
            return parent[n];
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

    }
}
