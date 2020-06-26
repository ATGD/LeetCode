package Problem_5346_二叉树中的列表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

import ext.ListNode;
import ext.TreeNode;

import java.util.ArrayList;
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        recursionNode(root, list, head.val);
        for (TreeNode treeNode : list) {
            if (isSubPathRecursion(treeNode, head)) return true;
        }
        return false;
    }

    private void recursionNode(TreeNode root, List<TreeNode> list, int val) {
        if (root == null) return;
        recursionNode(root.left, list, val);
        if (root.val == val) list.add(root);
        recursionNode(root.right, list, val);
    }

    private boolean isSubPathRecursion(TreeNode root, ListNode head) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        if (head.val != root.val) return false;
        else return isSubPathRecursion(root.left, head.next) || isSubPathRecursion(root.right, head.next);
    }
}

class Test {
    public static void main(String[] args) {
        String s = "\uFEFFㅤㅤㅤ";
        System.out.println(s.codePointCount(0, s.length()));
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(((int) s.charAt(i)));
//        }
    }
}