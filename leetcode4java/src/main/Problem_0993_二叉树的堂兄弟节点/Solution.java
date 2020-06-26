package Problem_0993_二叉树的堂兄弟节点;

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

    Construct construct1;
    Construct construct2;

    public boolean isCousins(TreeNode root, int x, int y) {
        construct2 = construct1 = null;
        int deep = 1;
        isXY(root, 1, x, y, null);
        if (construct1 == null) return false;
        if (construct2 == null) return false;
        if (construct1.deep != construct2.deep) return false;
        if (construct1.parent == construct2.parent) return false;
        return true;
    }

    private void isXY(TreeNode root, int deep, int x, int y, TreeNode parent) {
        if (root == null) return;
        if (root.val == x)
            construct1 = new Construct(deep, parent);
        if (root.val == y)
            construct2 = new Construct(deep, parent);
        isXY(root.left, deep + 1, x, y, root);
        isXY(root.right, deep + 1, x, y, root);
    }

    public class Construct {
        public int deep;
        public TreeNode parent;

        public Construct(int deep, TreeNode parent) {
            this.deep = deep;
            this.parent = parent;
        }
    }
}
