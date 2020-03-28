package Problem_5179_将二叉搜索树变平衡;

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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        searchTree(list, root);
//        0,1,2,3,4,5,6,7,8,9
        int midIndex = (list.size() - 1) / 2;
        TreeNode resultRoot = new TreeNode(list.get(midIndex).val);
        createTree(list, 0, midIndex - 1, resultRoot, true);
        createTree(list, midIndex + 1, list.size() - 1, resultRoot, false);
        return resultRoot;
    }

    private void createTree(List<TreeNode> list, int start, int end, TreeNode node, boolean isLeft) {
        if (start < 0 || end >= list.size() || start > end) return;
        int midIndex = start + (end - start) / 2;
        TreeNode resultRoot = new TreeNode(list.get(midIndex).val);
        if (isLeft) node.left = resultRoot;
        else node.right = resultRoot;
        createTree(list, start, midIndex - 1, resultRoot, true);
        createTree(list, midIndex + 1, end, resultRoot, false);
    }

    private void searchTree(List<TreeNode> list, TreeNode root) {
        if (root == null) return;
        searchTree(list, root.left);
        list.add(root);
        searchTree(list, root.right);
    }
}
