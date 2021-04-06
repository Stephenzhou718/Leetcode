package Recursive;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 4:37 下午
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * 思路:
 * 1. 深度优先遍历：时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 广度优先遍历：时间复杂度 O(n), 空间复杂度 O(n)
 *
 * 五毒神掌：
 * 第三遍，2021/4/6
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (leftDepth == 0 ) {
            return rightDepth + 1;
        }

        if (rightDepth == 0 ) {
            return leftDepth + 1;
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
