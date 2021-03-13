package LinkedList;

import java.util.HashSet;

/**
 * @Author: zhouhanming
 * @Date:2021/3/5 9:23 下午
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>
 * 思路：
 * 1. 把走过的 Node 都记录下来：时间复杂度 O(n), 空间复杂度 O(1)
 * 2. 快慢指针：时间复杂度 O(n), 空间复杂度 O(1)
 * <p>
 * 五毒神掌：
 * 第三遍，2021/3/7
 * 第四遍, 2021/3/13
 * 第五遍,
 */
public class LinkedListCycle {

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 记录 Node
    public boolean hasCycle_2(ListNode head) {
        if (head == null) {
            return false;
        }

        HashSet<ListNode> nodeSet =  new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }

        return false;
    }

}
