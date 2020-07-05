package Problem_0203_移除链表元素;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ahead = new ListNode(0);
        ListNode temp = ahead;
        ahead.next = head;
        while (temp != null) {
            ListNode nextNode = temp.next;
            while (nextNode != null && nextNode.val == val) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            temp = temp.next;
        }
        return ahead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

class Test{
    public static void main(String[] args) {
        Solution.ListNode _1node = new Solution.ListNode(1);
        Solution.ListNode _2node = new Solution.ListNode(6);
        _1node.next = _2node;
        Solution.ListNode _3node = new Solution.ListNode(6);
        _2node.next = _3node;
        Solution.ListNode _4node = new Solution.ListNode(4);
        _3node.next = _4node;
        Solution.ListNode _5node = new Solution.ListNode(6);
        _4node.next = _5node;
        Solution.ListNode _6node = new Solution.ListNode(9);
        _5node.next = _6node;
        Solution.ListNode _7node = new Solution.ListNode(8);
        _6node.next = _7node;
        Solution.ListNode listNode = new Solution().removeElements(_1node, 6);
        System.out.println(listNode);
    }
}



