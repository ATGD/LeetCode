package Gold_02_02_返回倒数第k个节点;

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
    public int kthToLast(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k - 1; i++) second = second.next;
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        return first.val;
    }
}