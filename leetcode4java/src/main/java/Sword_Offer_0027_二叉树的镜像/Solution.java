package Sword_Offer_0027_二叉树的镜像;

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
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode tmpNode = root.left;
            root.left = root.right;
            root.right = tmpNode;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }
}