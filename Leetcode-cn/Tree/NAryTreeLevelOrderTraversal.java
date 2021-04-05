package Tree;

import java.util.*;

/**
 * @Author: zhouhanming
 * @Date:2021/3/9 10:05 下午
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * 思路：
 * 1. 队列: 时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 简化的广度优先搜索：时间复杂度 O(n), 空间复杂度 O(n)
 *
 * 五毒神掌：
 * 第二遍, 2021/3/9
 * 第三遍, 2021/3/13
 * 第四遍, 2021/4/5
 */
public class NAryTreeLevelOrderTraversal {

    // 利用队列进行层次遍历
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                curList.add(node.val);
                deque.addAll(node.children);
            }
            res.add(curList);
        }
        return res;
    }

    // 简化的广度优先搜索
    public List<List<Integer>> levelOrder_2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Node> preLayer = Arrays.asList(root);

        while (!preLayer.isEmpty()) {
            List<Integer> preVal = new ArrayList<>();
            List<Node> curLayer = new ArrayList<>();

            for (Node node : preLayer) {
                preVal.add(node.val);
                curLayer.addAll(node.children);
            }
            res.add(preVal);
            preLayer = curLayer;
        }
        return res;
    }
}
