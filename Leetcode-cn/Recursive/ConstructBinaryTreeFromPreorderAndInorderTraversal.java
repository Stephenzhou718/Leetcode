package Recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 9:42 下午
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 思路：
 * 1. 先构建出 root 节点，再递归构建出左子树与右子树：时间复杂度 O(n^2), 空间复杂度 O(n)
 * 2. 在 1 的基础上，用 hashmap 存储 inorder 的节点与 index 映射：时间复杂度 O(n), 空间复杂度 O(n)
 *
 *
 * 五毒神掌：
 * 第二遍, 2021/3/14
 * 第三遍, 2021/4/8
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeCore(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeCore(int[] preorder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);

        int leftCount = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inOrder[i] == preorder[pStart]) {
                leftCount = i - iStart;
            }
        }

        root.left = buildTreeCore(preorder, pStart + 1, pStart + leftCount + 1, inOrder, iStart, iStart + leftCount);
        root.right = buildTreeCore(preorder, pStart + leftCount + 1, pEnd, inOrder, iStart + leftCount + 1, iEnd);
        return root;
    }

    private TreeNode buildTreeCore_2(int[] preorder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);

        int leftCount = map.get(preorder[pStart]) - iStart;

        root.left = buildTreeCore(preorder, pStart + 1, pStart + leftCount + 1, inOrder, iStart, iStart + leftCount);
        root.right = buildTreeCore(preorder, pStart + leftCount + 1, pEnd, inOrder, iStart + leftCount + 1, iEnd);
        return root;
    }
}
