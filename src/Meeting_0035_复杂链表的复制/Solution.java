package Meeting_0035_复杂链表的复制;

import ext.Node;

import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        List<Node> oriList = new ArrayList<>();
        List<Node> newList = new ArrayList<>();
        Node resultAhead = new Node(0);
        Node tmp = resultAhead;
        while (head != null) {

            Node node = new Node(head.val);
            newList.add(node);
            tmp.next = node;
            tmp = tmp.next;

            oriList.add(head);
            head = head.next;
        }
        for (int i = 0; i < oriList.size(); i++) {
            Node oriNode = oriList.get(i);
            Node newNode = newList.get(i);
            if (oriNode.random != null) {
                int index = oriList.indexOf(oriNode.random);
                newNode.random = newList.get(index);
            }
        }
        return resultAhead.next;
    }
}