package Problem_0559_N叉树的最大深度;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
// Definition for a Node.
*/
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
    public int maxDepth(Node root) {
//        if (root == null) return 0;
//        int max = 0;
//        List<Node> childrens = root.children;
//        for (int i = 0; i < childrens.size(); i++) {
//            int depth = maxDepth(childrens.get(i));
//            if (depth > max)
//                max = depth;
//        }
//        return 1 + max;
        if (root == null) return 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.pollFirst();
                for (Node child : poll.children)
                    queue.addLast(child);
            }
            depth++;
        }
        return depth;
    }
}

