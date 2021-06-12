package Meeting_02_0003_删除中间节点;


import ext.ListNode;

class Solution {
    public void deleteNode(ListNode node) {
        ListNode tmpNode = node;
        while (tmpNode != null) {
            if (tmpNode.next != null) {
                tmpNode.val = tmpNode.next.val;
                if (tmpNode.next.next == null) {
                    tmpNode.next = null;
                }
            }
            tmpNode = tmpNode.next;
        }
    }
}