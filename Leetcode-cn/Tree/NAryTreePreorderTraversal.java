package Tree;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zhouhanming
 * @Date:2021/3/9 9:55 下午
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * 思路：
 * 1. 递归
 * 2. 迭代
 *
 * 五毒神掌：第二遍，第三遍时间：2021/3/10
 */
public class NAryTreePreorderTraversal {

    // 递归
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderCore(root, res);
        return res;
    }

    private void preorderCore(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (Node node : root.children) {
            preorderCore(node, res);
        }
    }

    // 迭代
    public List<Integer> preorder_2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();
            if (colorNode.color.equals("white")) {
                Collections.reverse(colorNode.node.children);
                for (Node node : colorNode.node.children) {
                    stack.push(new ColorNode(node, "white"));
                }
                stack.push(new ColorNode(colorNode.node, "gray"));
            } else {
                res.add(colorNode.node.val);
            }
        }

        return res;
    }

    class ColorNode {
        Node node;
        String color;

        public ColorNode(Node node, String color) {
            this.node = node;
            this.color = color;
        }
    }
}
