package Gold_02_08_环路检测;

import ext.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isStart = false;
        while ((!isStart || fast != slow) && fast != null) {
            isStart = true;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == null) return null;
        ListNode three = head;
        while (three != slow) {
            three = three.next;
            slow = slow.next;
        }
        return three;
    }
}

class Test {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode listNode = new Solution().detectCycle(node0);
        System.out.println(listNode);
    }
    //0,0
    //1,2
    //2,4
    //3,2
    //4,4
}
