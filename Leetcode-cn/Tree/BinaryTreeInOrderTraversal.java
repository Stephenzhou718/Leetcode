package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zhouhanming
 * @Date:2021/3/9 8:30 下午
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * 思路：
 * 1. 递归: 时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 栈: 时间复杂度 O(n), 空间复杂度 O(n)
 *
 * 五毒神掌：
 * 第二遍, 2021/3/9
 * 第三遍, 2021/3/13
 * 第四遍,
 */
public class BinaryTreeInOrderTraversal {

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalCore(root, res);
        return res;
    }

    private void inorderTraversalCore(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        inorderTraversalCore(root.left, values);
        values.add(root.val);
        inorderTraversalCore(root.right, values);
    }


    // 迭代 (Node 带有一个标记，用来表示节点是否被访问过）
    public List<Integer> inorderTraversal_2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));
        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();
            if (colorNode.color.equals("white")) {
                if (colorNode.node.right != null) stack.push(new ColorNode(colorNode.node.right, "white"));
                stack.push(new ColorNode(colorNode.node, "gray"));
                if (colorNode.node.left != null) stack.push(new ColorNode(colorNode.node.left, "white"));
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
