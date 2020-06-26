package Problem_0145_二叉树的后序遍历;

import ext.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (queue.size() != 0) {
            TreeNode tmpNode = queue.peekFirst();
            if (tmpNode.left == null && tmpNode.right == null) {
                list.add(tmpNode.val);
                queue.pollFirst();
                continue;
            }
            if (tmpNode.right != null) {
                TreeNode right = tmpNode.right;
                tmpNode.right = null;
                queue.addFirst(right);
            }
            if (tmpNode.left != null) {
                TreeNode left = tmpNode.left;
                tmpNode.left = null;
                queue.addFirst(left);
            }
        }
        return list;
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node.right = node1;
        node1.left = node2;

        List<Integer> integers = new Solution().postorderTraversal(node);
        System.out.println(integers);
    }
}