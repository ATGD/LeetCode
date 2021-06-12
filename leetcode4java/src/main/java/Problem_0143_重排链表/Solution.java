package Problem_0143_重排链表;

import ext.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode moveForLength = head;
        int length = 0;
        while (moveForLength != null) {
            length++;
            moveForLength = moveForLength.next;
        }

        int tempHalf = ((length & 1) == 1) ? (length / 2 + 1) : (length / 2);
        ListNode lastHalf = head;
        while (lastHalf != null && tempHalf > 0) {
            if (tempHalf == 1) {
                lastHalf.next = null;
            } else {
                lastHalf = lastHalf.next;
                tempHalf--;
            }

        }

        ListNode reverseTmpNode = lastHalf;
        ListNode LastListNode = null;
        while (reverseTmpNode != null) {
            ListNode thirdNode = reverseTmpNode;
            reverseTmpNode = reverseTmpNode.next;
            thirdNode.next = LastListNode;
            LastListNode = thirdNode;
        }

        ListNode firstHalfNode = head;
        while (LastListNode != null) {
            ListNode thirdNode4First = firstHalfNode;
            if (firstHalfNode.next == lastHalf) {
                firstHalfNode = null;
            } else {
            firstHalfNode = firstHalfNode.next;
            }
            ListNode thirdNode4Last = LastListNode;
            LastListNode = LastListNode.next;
            thirdNode4First.next = thirdNode4Last;
            thirdNode4Last.next = firstHalfNode;
        }
    }
}

