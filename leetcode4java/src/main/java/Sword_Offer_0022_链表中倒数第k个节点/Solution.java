package Sword_Offer_0022_链表中倒数第k个节点;

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
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        while (k > 0) {
            end = end.next;
            k--;
        }
        while (end != null) {
            start = start.next;
            end = end.next;
        }
        return start;
    }
}