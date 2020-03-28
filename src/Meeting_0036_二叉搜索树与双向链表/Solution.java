package Meeting_0036_二叉搜索树与双向链表;

import ext.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node newhead = helper(root);
        //创建头尾相连
        Node temp = newhead;
        while(temp.right != null){
            temp = temp.right;
        }
        //进行头尾相连
        temp.right = newhead;
        newhead.left = temp;
        return newhead;
    }
    //转换为双向不循环链表
    public Node helper(Node root){
        if(root == null) return null;
        if(root.left != null){
            //找到最小的值
            Node left = helper(root.left);
//            while(left.right != null) left = left.right;
            //进行小值双向赋值
            root.left = left;
            left.right = root;
        }
        if(root.right != null){
            Node right = helper(root.right);
            //进行大值双向赋值
            root.right = right;
            right.left = root;
        }
//        while(root.left != null){
//            root = root.left;
//        }
        return root;
    }

}

class Test {
    public static void main(String[] args) {
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node10 = new Node(10);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);
        Node node16 = new Node(16);
        Node node17 = new Node(17);
        Node node19 = new Node(19);
        node10.left = node5;
        node10.right = node15;
        node5.left = node3;
        node5.right = node7;
        node15.left = node13;
        node15.right = node17;
        node3.left = node2;
        node3.right = node4;
        node7.left = node6;
        node7.right = node8;
        node13.left = node12;
        node13.right = node14;
        node17.left = node16;
        node17.right = node19;
        Node node = new Solution().treeToDoublyList(node10);
        System.out.println(node);
    }
}