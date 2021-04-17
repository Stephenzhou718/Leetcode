package Recursive;

import java.util.TreeMap;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 3:58 下午
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * 思路：
 * 1. 中序遍历：时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 递归 + 上下界值: 时间复杂度 O(n), 空间复杂度 O(n)
 * 五毒神掌：
 * 第二遍, 2021/3/14
 * 第三遍, 2021/4/6
 * 第四遍，2021/4/17
 */
public class ValidateBinarySearchTree {

    // 递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root , long left, long right) {
        if (root == null) {
            return true;
        }

        if (root.val <= left || root.val >= right) {
            return false;
        }

        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }

    // 中序遍历
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST_2(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST_2(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST_2(root.right);
    }


}
