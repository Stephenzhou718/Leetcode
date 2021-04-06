package Recursive;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 4:29 下午
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * 思路：
 * 1. 深度优先遍历: 时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 广度优先遍历，记录拓展的次数
 *
 * 五毒神掌：
 * 第二遍, 2021/3/14
 * 第三遍，2021/4/6
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
