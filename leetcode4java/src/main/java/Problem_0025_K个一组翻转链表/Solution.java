package Problem_0025_K个一组翻转链表;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode countNode = head;
        int size = countLinked(countNode);

        ListNode resultHead = null;

        ListNode stepHead = null;
        ListNode stepTail = null;

        while (head != null) {
            int mK = 0;
            ListNode tmpHead = null;    //k循环内作为链表的头
            ListNode tmpTail = head;    //k循环内作为链表的尾巴

            if (size < k){
                if (stepTail != null)
                    stepTail.next = head;
                break;
            }

            while (mK < k && head != null) {
                ListNode next = head.next;
                head.next = tmpHead;
                tmpHead = head;
                head = next;
                mK++;
                size--;
            }

            if (stepTail != null)
                stepTail.next = tmpHead;

            stepTail = tmpTail;

            if (stepHead == null)
                resultHead = tmpHead;

            stepHead = tmpHead;
        }
        return resultHead;
    }

    private int countLinked(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        ListNode head0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        head0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode listNode = new Solution().reverseKGroup(head0, 7);
        System.out.println(listNode);
    }
}
