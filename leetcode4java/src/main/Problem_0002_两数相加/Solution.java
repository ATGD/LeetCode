package Problem_0002_两数相加;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = l1.val + l2.val;
        boolean flag = false;
        if (value >= 10) {
            value -= 10;
            flag = true;
        }
        ListNode l3 = new ListNode(value);
        ListNode l4 = l3;
        while (l1.next != null || l2.next != null) {
            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
            value = l1.val + l2.val;
            if (flag) {
                value++;
            }
            if (value >= 10) {
                value -= 10;
                flag = true;
            } else {
                flag = false;
            }
            l4 = l4.next = new ListNode(value);
        }
        if (flag) {
            l4 = l4.next = new ListNode(1);
        }
        return l3;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

