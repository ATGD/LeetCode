package Gold_02_05_链表求和;

import ext.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmpNode = head;
        int extra = 0;
        while (l1 != null || l2 != null) {
            int result = extra;
            if (l1 != null) {
                result += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result+=l2.val;
                l2 = l2.next;
            }
            extra = result / 10;
            result = result % 10;
            tmpNode.next = new ListNode(result);
            tmpNode = tmpNode.next;
        }
        if (extra != 0)
            tmpNode.next = new ListNode(extra);
        return head.next;
    }
}