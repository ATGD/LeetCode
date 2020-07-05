package Problem_0024_两两交换链表中的节点;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode firstNode = new ListNode(0);
        firstNode.next = head;
        swapLoop(firstNode, head);
        return firstNode.next;
    }

    private void swapLoop(ListNode lastNode, ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode nextChainNode = head.next.next;
        ListNode next_next = head.next;
        lastNode.next = next_next;
        next_next.next = head;
        head.next = nextChainNode;
        swapLoop(head, nextChainNode);
    }
}

