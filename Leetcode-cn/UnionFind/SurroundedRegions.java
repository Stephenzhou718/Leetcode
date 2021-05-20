package UnionFind;

/**
 * @Author: zhouhanming
 * @Date:2021/5/18 11:52 下午
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * 思路：
 * 1. DFS
 * 2. BFS
 * 3. 并查集
 *
 * 五毒神掌：
 * 第二遍，2021/5/19
 * 第三遍, 2021/5/21
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        // 用一个虚拟节点，边界上的 O 的父节点都是这个虚拟节点
        UnionFind unionFind = new UnionFind(m * n + 1);
        int dummyNode = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1|| j == 0 || j == n - 1) {
                        // 边界上的 O。把它和 dummuNode 合并成一个联通区域
                        unionFind.union(i * n + j, dummyNode);
                    } else {
                        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                            unionFind.union(i * n + j, (i - 1) * n + j);
                        }
                        if (i + 1 < m && board[i + 1][j] == 'O') {
                            unionFind.union(i * n + j, (i + 1) * n + j);
                        }
                        if (j - 1>= 0 && board[i][j - 1] == 'O') {
                            unionFind.union(i * n + j, i * n + j - 1);
                        }
                        if (j + 1 < n && board[i][j + 1] == 'O') {
                            unionFind.union(i * n + j, i * n + j + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (unionFind.isConnected(i * n + j, dummyNode)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;

        public UnionFind (int n) {
            count = 0;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find (int i) {
            while (i != parent[i]) i = parent[i];
            return parent[i];
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
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
            }
        }
    }
}
