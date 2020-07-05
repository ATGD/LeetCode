package Problem_0606_根据二叉树创建字符串;

import ext.TreeNode;

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
    StringBuffer buffer = new StringBuffer();

    public String tree2str(TreeNode t) {
        buffer.delete(0, buffer.length());
        executeTree2str(t);
        return buffer.toString();
    }

    private void executeTree2str(TreeNode t) {
        if (t == null) return;
        buffer.append(t.val);
        if (t.left == null && t.right == null) return;
        buffer.append("(");
        if (t.left != null) executeTree2str(t.left);
        buffer.append(")");
        if (t.right != null) {
            buffer.append("(");
            executeTree2str(t.right);
            buffer.append(")");
        }
    }
}
