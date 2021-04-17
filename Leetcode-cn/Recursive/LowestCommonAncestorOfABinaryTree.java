package Recursive;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 9:26 下午
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 思路：
 * 1. 递归: 时间复杂度 O(n), 空间复杂度 O(n)
 *
 * 五毒神掌：
 * 第二遍，2021/3/14
 * 第三遍, 2021/4/7
 * 第四遍，2021/4/17
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
