package Problem_1315_祖父节点值为偶数的节点和;

import ext.TreeNode;

import java.util.LinkedList;

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

    int count = 0;

    public int sumEvenGrandparent(TreeNode root) {
        TreeNode grandParent = new TreeNode(1);
        TreeNode parent = new TreeNode(1);

        grandParent.left = parent;
        parent.left = root;

        dfs(grandParent, parent, root);
        return count;
    }

    private void dfs(TreeNode grandParent, TreeNode parent, TreeNode root) {

        if (root == null) return;

        dfs(parent,root,root.left);

        if ((grandParent.val & 1) == 0)
            count+=root.val;

        dfs(parent,root,root.right);
    }
}
