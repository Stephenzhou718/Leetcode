package Recursive;


/**
 * @Author: zhouhanming
 * @Date:2021/3/14 3:26 下午
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 *
 * 思路：
 * 1. 套递归模版
 *
 * 五毒神掌：
 * 第二遍, 2021/3/14
 * 第三遍，2021/4/6
 * 第四遍，
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}
