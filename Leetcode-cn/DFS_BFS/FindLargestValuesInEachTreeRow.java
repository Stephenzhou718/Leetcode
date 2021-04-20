package DFS_BFS;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/4/18 9:35 下午
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 *
 * 五毒神掌：
 * 第二遍，2021/4/19
 * 第三遍，2021/4/20
 * 第四遍，
 */
public class FindLargestValuesInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while(!deque.isEmpty()) {
            int size = deque.size();
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                maxValue = Math.max(node.val, maxValue);

                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            res.add(maxValue);
        }

        return res;
    }
}
