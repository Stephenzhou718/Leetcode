package Tree;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zhouhanming
 * @Date:2021/3/9 9:33 下午
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * 思路：
 * 1. 迭代
 * 2. 递归
 *
 * 五毒神掌：
 * 第二遍, 2021/3/9
 * 第三遍, 2021/3/13
 * 第四遍,
 */
public class NAryTreePostorderTraversal {

    // 递归
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderCore(root, res);
        return res;
    }

    private void postorderCore(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            postorderCore(node, res);
        }
        res.add(root.val);
    }

    // 迭代
    public List<Integer> postorder_2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();
            if (colorNode.color.equals("white")) {
                stack.push(new ColorNode(colorNode.node, "gray"));
                Collections.reverse(colorNode.node.children);
                for (Node node : colorNode.node.children) {
                    stack.push(new ColorNode(node, "white"));
                }
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