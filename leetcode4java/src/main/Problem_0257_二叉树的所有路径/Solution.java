package Problem_0257_二叉树的所有路径;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        treeRecursion(resultList, "", root);
        return resultList;
    }

    private void treeRecursion(List<String> resultList, String buffer, TreeNode root) {
        if (root == null) {
            if (!buffer.isEmpty()) resultList.add(buffer);
            return;
        }
        if (buffer.isEmpty()) buffer += root.val;
        else buffer += "->" + root.val;
        if (root.right != null)
            treeRecursion(resultList, buffer, root.left);
        if (root.right != null)
            treeRecursion(resultList, buffer, root.right);
        if (root.left == null && root.right == null) {
            if (!buffer.isEmpty()) resultList.add(buffer);
        }
    }
}

