package LinkedList;

import java.util.HashSet;

/**
 * @Author: zhouhanming
 * @Date:2021/3/6 2:50 下午
 *
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * 思路：
 * 1. 记下走过的节点： 时间复杂度 O(n), 空间复杂度 O(n)
 * 2. 快慢指针：时间复杂度 O(n), 空间复杂度 O(1)
 *
 * 五毒神掌：
 * 第二遍，2021/3/6
 * 第三遍, 2021/3/7
 * 第四遍, 2021/3/13
 * 第五遍，
 */
public class LinkedListCycle2 {

    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) return null;

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // 记下走过的节点
    public ListNode detectCycle_2(ListNode head) {
        if (head == null) return null;

        HashSet<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return null;
    }
}
