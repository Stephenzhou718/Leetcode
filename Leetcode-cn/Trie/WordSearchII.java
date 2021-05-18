package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhouhanming
 * @Date:2021/5/18 10:11 下午
 * https://leetcode-cn.com/problems/word-search-ii/
 *
 * 思路：
 * 1. Trie + DFS
 *
 * 五毒神掌：
 * 第二遍：2021/5/18
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return new ArrayList<>();
        }

        // 构建 trie 树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, trie, new StringBuilder(), i, j, visited, res);
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, Trie trie, StringBuilder sb, int i, int j, boolean[][] visited, Set<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || trie.children[board[i][j] - 'a'] == null) {
            return;
        }

        visited[i][j] = true;
        trie = trie.children[board[i][j] - 'a'];
        sb.append(board[i][j]);
        if (trie.isEnd) {
            res.add(sb.toString());
        }

        dfs(board, trie, sb, i - 1, j, visited, res);
        dfs(board, trie, sb, i + 1, j, visited, res);
        dfs(board, trie, sb, i, j - 1, visited, res);
        dfs(board, trie, sb, i, j + 1, visited, res);

        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
