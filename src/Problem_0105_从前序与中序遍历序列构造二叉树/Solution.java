package Problem_0105_从前序与中序遍历序列构造二叉树;

import ext.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    private Map<Integer, Integer> mapPre = new HashMap<>();
    private Map<Integer, Integer> mapIn = new HashMap<>();
    private int tmpIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1) return null;
        for (int i = 0; i < preorder.length; i++) mapPre.put(preorder[i], i);
        for (int i = 0; i < inorder.length; i++) mapIn.put(inorder[i], i);
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            tmpIndex++;
            return new TreeNode(inorder[start]);
        }
        Integer index = mapIn.get(preorder[tmpIndex]);
        TreeNode treeNode = new TreeNode(preorder[tmpIndex++]);
        treeNode.left = buildTree(preorder, inorder, start, index - 1);
        treeNode.right = buildTree(preorder, inorder, index + 1, end);
        return treeNode;
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution().buildTree(new int[]{
                        4, 1, 2, 3
                },
                new int[]{
                        1, 2, 3, 4
                });
        System.out.println(treeNode);
    }
}
