package Problem_5283_二进制链表转整数;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int getDecimalValue(ListNode head) {
        int accum = 0;
        while (head != null) {
            accum = (accum << 1) + head.val;
            head = head.next;
        }
        return accum;
    }
}

