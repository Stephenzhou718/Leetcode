/**
 * @(#)P12.java, Aug 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author zhouhanming
 * medium -
 * 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class P12 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, visited, i, j, new StringBuilder(), word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int i, int j, StringBuilder sb, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(sb.length()) != board[i][j]) {
            return false;
        }

        sb.append(board[i][j]);
        visited[i][j] = true;

        if (sb.length() == word.length()) {
            return sb.toString().equals(word);
        }

        if (dfs(board, visited, i + 1, j, sb, word)
                || dfs(board, visited, i - 1, j, sb, word)
                || dfs(board, visited, i, j + 1, sb, word)
                || dfs(board, visited, i, j - 1, sb, word)) {
            return true;
        }

        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
        return false;
    }
}