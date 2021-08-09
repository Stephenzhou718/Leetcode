/**
 * @(#)P7.java, Aug 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhanming
 * medium - 要注意细节
 * 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/submissions/
 */
public class P7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private TreeNode buildTreeCore(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight, Map<Integer, Integer> inorderIndexMap) {
        if (pLeft > pRight) {
            return null;
        } else if (pLeft == pRight) {
            return new TreeNode(preorder[pLeft]);
        }

        TreeNode node = new TreeNode(preorder[pLeft]);

        int rootIndex = inorderIndexMap.get(preorder[pLeft]);
        int leftSize = rootIndex - iLeft;

        node.left = buildTreeCore(preorder, pLeft + 1, pLeft + leftSize, inorder, iLeft, iLeft + leftSize - 1, inorderIndexMap);
        node.right = buildTreeCore(preorder, pLeft + 1 + leftSize, pRight, inorder, iLeft + leftSize + 1, iRight, inorderIndexMap);

        return node;
    }

}