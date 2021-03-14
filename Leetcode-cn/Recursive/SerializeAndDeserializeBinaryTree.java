package Recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 4:55 下午
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 思路：
 * 1. DFS 前序遍历：时间复杂度 O(n), 空间复杂度 O(n)
 *
 * 五毒神掌：
 * 第二遍, 2021/3/14
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeCore(root, sb);
        return sb.toString();
    }

    private void serializeCore(TreeNode root, StringBuilder sb) {
        if (root ==  null) {
            sb.append("None,");
            return;
        }

        sb.append(root.val).append(",");
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new ArrayList<>(Arrays.asList(data_array));
        return deserializeCore(data_list);
    }

    private TreeNode deserializeCore(List<String> data) {
        if (data.get(0).equals("None")) {
            data.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);

        node.left = deserializeCore(data);
        node.right = deserializeCore(data);

        return node;
    }
}
