package Problem_0589_N叉树的前序遍历;

import java.util.LinkedList;
import java.util.List;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollFirst();
            output.addLast(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.addFirst(node.children.get(i));
            }
        }
        return output;
    }
}

//}

class Test {
    public static void main(String[] args) {
    }
}

