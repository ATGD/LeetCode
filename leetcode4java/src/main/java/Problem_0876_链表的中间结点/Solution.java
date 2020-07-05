package Problem_0876_链表的中间结点;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode oneNode = new ListNode(0);
        ListNode twoNode = new ListNode(0);
        oneNode.next = head;
        twoNode.next = head;
        while (twoNode != null) {
            if (twoNode.next == null)
                return oneNode.next;
            else if (twoNode.next.next == null)
                return oneNode.next;
            else {
                twoNode = twoNode.next.next;
                oneNode = oneNode.next;
            }
        }
        return oneNode;
    }
}

