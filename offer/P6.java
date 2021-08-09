/**
 * @(#)P6.java, Aug 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhanming
 * easy - 一次过
 * 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class P6 {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        reversePrintCore(head, res);
        return toArray(res);
    }

    private void reversePrintCore(ListNode head, List<Integer> res) {
        if (head == null) {
            return;
        }

        reversePrintCore(head.next, res);
        res.add(head.val);
    }

    private int[] toArray(List<Integer> list) {
        int[] resArr = new int[list.size()];

        int index = 0;
        for (int num : list) {
            resArr[index++] = num;
        }

        return resArr;
    }
}