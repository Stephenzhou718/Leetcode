package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zhouhanming
 * @Date:2021/3/9 9:12 下午
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * 思路：
 * 1. 递归: 时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 迭代: 时间复杂度 O(n), 空间复杂度 O(n)
 *
 * 五毒神掌：第二遍，第三遍时间 2021/3/10
 */
public class BinaryTreePreorderTraversal {

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        preorderTraversalCore(root, res);
        return res;
    }

    private void preorderTraversalCore(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preorderTraversalCore(root.left, res);
        preorderTraversalCore(root.right, res);
    }

    // 迭代 (给 Node 新增一个属性来表示节点是否被访问）
    public List<Integer> preorderTraversal_2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();

            if (colorNode.color.equals("white")) {
                if (colorNode.node.right != null) stack.push(new ColorNode(colorNode.node.right, "white"));
                if (colorNode.node.left != null) stack.push(new ColorNode(colorNode.node.left, "white"));
                stack.push(new ColorNode(colorNode.node, "gray"));
            } else {
                res.add(colorNode.node.val);
            }
        }
        return res;
    }

    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }
}