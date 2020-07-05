package Gold_04_05_合法二叉搜索树;

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

    Integer value = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (value != null && root.val <= value) return false;
        value = root.val;
        if (!isValidBST(root.right)) return false;
        return true;
    }
}