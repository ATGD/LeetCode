package Problem_0019_删除链表的倒数第N个节点;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode aHead = new ListNode(0);
        aHead.next = head;
        int moveCount = 0;
        ListNode fastNode = aHead;
        ListNode slowNode = aHead;
        while (moveCount < n) {
            ListNode next = fastNode.next;
            fastNode = next;
            moveCount++;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        if (slowNode.next != null) {
            slowNode.next = slowNode.next.next;
        }
        return aHead.next;
    }
}

