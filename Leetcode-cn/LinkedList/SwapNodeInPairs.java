package LinkedList;

/**
 * @Author: zhouhanming
 * @Date:2021/3/4 11:22 下午
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * 思路：
 * 链表问题就没啥模版，就是画图看，一步一步推导
 * 1. 递归：时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 迭代: 时间复杂度 O(n), 空间复杂度 O(1)
 *
 * 五毒神掌：第二遍，第三遍时间：2021/3/5
 */
public class SwapNodeInPairs {

    // 递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }

    // 迭代
    public ListNode swapPairs_2(ListNode head) {
        if (head ==  null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = node1.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return dummyHead.next;
    }
}
