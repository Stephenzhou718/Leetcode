package LinkedList;

/**
 * @Author: zhouhanming
 * @Date:2021/3/4 10:40 下午
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 解法：
 * 1. 迭代
 * 2. 递归
 * 3. 栈
 *
 * 五毒神掌：
 * 第三遍，2021/3/8
 * 第四遍, 2021/3/13
 * 第五遍，
 */
public class ReverseLinkedList {

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;


        ListNode next = head.next;
        ListNode node = reverseList(next);
        head.next = null;
        next.next = head;
        return node;
    }

    // 循环
    public ListNode reverseList_2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
