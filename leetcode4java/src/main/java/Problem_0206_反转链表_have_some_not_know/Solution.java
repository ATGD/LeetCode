package Problem_0206_反转链表_have_some_not_know;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList1(ListNode head) {
        if (head == null)
            return null;
        ListNode ahead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = ahead;
            ahead = head;
            head = next;
        }
        return ahead;
    }

    public ListNode reverseList2(ListNode head) {
        return resesrseNextList(null, head);
    }

    public ListNode resesrseNextList(ListNode ahead, ListNode head) {
        if (head == null)
            return ahead;
        ListNode next = head.next;
        head.next = ahead;
        ahead = head;
        head = next;
        return resesrseNextList(ahead, head);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

class Test {

    public static void main(String[] args) {
        Solution.ListNode listNode1 = new Solution.ListNode(1);
        Solution.ListNode listNode2 = new Solution.ListNode(2);
        listNode1.next = listNode2;
        Solution.ListNode listNode3 = new Solution.ListNode(34);
        listNode2.next = listNode3;
        Solution.ListNode listNode4 = new Solution.ListNode(45);
        listNode3.next = listNode4;
        Solution.ListNode listNode5 = new Solution.ListNode(56);
        listNode4.next = listNode5;
        Solution.ListNode listNode6 = new Solution.ListNode(67);
        listNode5.next = listNode6;
        Solution.ListNode listNode7 = new Solution.ListNode(78);
        listNode6.next = listNode7;
        Solution.ListNode listNode = new Solution().reverseList(listNode1);
        System.out.println(listNode);
    }
}

