/**
 * @Author: zhouhanming
 * @Date:2020/8/17 11:04 下午
 * 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree_110 {
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        height(root);
        return isBalance;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return 1 + Math.max(left, right);
    }


}
