package Problem_0968_监控二叉树;

import ext.TreeNode;

import java.util.LinkedList;


class Solution {
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean should = true;
        int count1 = 0;
        int count2 = 1;
        while (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = list.pollFirst();
                if (treeNode.left != null) {
                    list.addLast(treeNode.left);
                    if (should)
                        count1++;
                }
                if (treeNode.right != null) {
                    list.addLast(treeNode.right);
                    if (should)
                        count1++;
                }
            }
            should = !should;
        }
        list.clear();
        should = false;
        list.add(root);
        while (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = list.pollFirst();
                if (treeNode.left != null) {
                    list.addLast(treeNode.left);
                    if (should)
                        count2++;
                }
                if (treeNode.right != null) {
                    list.addLast(treeNode.right);
                    if (should)
                        count2++;
                }
            }
            should = !should;
        }
        return Math.min(count1, count2);
    }
}


class Test {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.makeTreeNode(new Object[]{0, 0, null, null, 0, 0, null, null, 0, 0});
        int i = new Solution().minCameraCover(treeNode);
        System.out.println(i);
    }
}

