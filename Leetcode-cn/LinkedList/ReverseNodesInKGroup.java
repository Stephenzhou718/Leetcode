package LinkedList;

import java.util.Stack;

/**
 * @Author: zhouhanming
 * @Date:2021/3/6 3:27 下午
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * 思路：需要把翻转链表整个进来
 * 1. 遍历：时间复杂度 O(n), 空间负载 O(n/k)
 * 2. 栈：时间复杂度 O(n), 空间复杂度 O(k)
 * 3. 递归: 时间复杂度 O(n), 空间复杂度 O(n/k)
 *
 * 五毒神掌：第二遍， 第三遍时间：2021/3/7
 * 五毒神掌：第三遍，第四遍时间：2021/3/18
 */
public class ReverseNodesInKGroup {

    // 遍历
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode end = dummyNode;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummyNode.next;
    }

    // 栈
    public ListNode reverseKGroup_2(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        while (head != null) {
            int count = 0;
            ListNode temp = head;
            for (int i = 0; i < k && temp != null; i++, count++) {
                stack.push(temp);
                temp = temp.next;
            }

            if (count < k) {
                pre.next = head;
                break;
            }

            while (!stack.isEmpty()) {
                pre.next = stack.pop();
                pre = pre.next;
            }
            pre.next = temp;
            head = temp;
        }

        return dummyNode.next;
    }

    // 递归
    public ListNode reverseKGroup_3(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode tail = head;
            for (int i = 1; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) return head;

            ListNode next = tail.next;
            tail.next = null;
            ListNode curHead = reverse(head);
            head.next = reverseKGroup_3(next, k);

            return curHead;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode node = reverse(head.next);
        next.next = head;
        head.next = null;
        return node;
    }
}
