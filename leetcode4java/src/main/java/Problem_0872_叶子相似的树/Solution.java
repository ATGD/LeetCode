package Problem_0872_叶子相似的树;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();
        putLeaves(root1List, root1);
        putLeaves(root2List, root2);
        if (root1List.size() != root2List.size()) return false;
        for (int i = 0; i < root1List.size(); i++) {
            if (root1List.get(i) != root2List.get(i))
                return false;
        }
        return true;
    }

    private void putLeaves(List<Integer> rootList, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) rootList.add(root.val);
        if (root.left != null) putLeaves(rootList, root.left);
        if (root.right != null) putLeaves(rootList, root.right);
    }

}

