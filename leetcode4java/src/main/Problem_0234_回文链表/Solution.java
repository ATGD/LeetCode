package Problem_0234_回文链表;

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
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null) return true;
            ListNode slow = head, fast = head.next, pre = null, prepre = null;
            while(fast != null && fast.next != null) {
                //反转前半段链表
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
                //先移动指针再来反转
                pre.next = prepre;
                prepre = pre;
            }
            ListNode p2 = slow.next;
            slow.next = pre;
            ListNode p1 = fast == null? slow.next : slow;
            while(p1 != null) {
                if(p1.val != p2.val)
                    return false;
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;


//        if (head == null)
//            return true;
//        if (head.next == null)
//            return true;
//        ListNode afterHead = findAfterHead(head);
//        ListNode reserveNode = reserveOneNodeList(afterHead);
//        while (head != null && reserveNode != null) {
//            if (head.val != reserveNode.val)
//                return false;
//            head = head.next;
//            reserveNode = reserveNode.next;
//        }
//        return true;
    }

    public ListNode reserveOneNodeList(ListNode head) {
        ListNode ahead = head;
        ListNode next = head.next;
        ahead.next = null;
        while (next != null) {
            ListNode tempNext = next.next;
            next.next = ahead;
            ahead = next;
            next = tempNext;
        }
        return ahead;
    }

    public ListNode findAfterHead(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        while (second.next != null) {
            if (second.next.next != null) {
                first = first.next;
                second = second.next.next;
            } else {
                return first.next.next;
            }
        }
        return first.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

class Test {

    public static void main(String[] args) {
        Solution.ListNode _1node = new Solution.ListNode(1);
        Solution.ListNode _2node = new Solution.ListNode(6);
        _1node.next = _2node;
//        Solution.ListNode _3node = new Solution.ListNode(6);
//        _2node.next = _3node;
//        Solution.ListNode _4node = new Solution.ListNode(4);
//        _3node.next = _4node;
//        Solution.ListNode _5node = new Solution.ListNode(6);
//        _4node.next = _5node;
//        Solution.ListNode _6node = new Solution.ListNode(9);
//        _5node.next = _6node;
//        Solution.ListNode _7node = new Solution.ListNode(8);
//        _6node.next = _7node;
        boolean isPalindrome = new Solution().isPalindrome(_1node);
        System.out.println(isPalindrome);
    }
}

