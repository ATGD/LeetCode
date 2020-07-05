package Problem_0107_二叉树的层次遍历2;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> outList = new ArrayList<>();
        if (root == null) return outList;
        levelOrderBottom(outList, root, 1);
        Collections.reverse(outList);
        return outList;
    }

    private void levelOrderBottom(List<List<Integer>> outList, TreeNode root, int depth) {
        if (root == null) return;
        List<Integer> innerList;
        if (outList.size() < depth) {
            innerList = new ArrayList<>();
            outList.add(innerList);
        } else innerList = outList.get(depth - 1);
        innerList.add(root.val);
        depth++;
        levelOrderBottom(outList, root.left, depth);
        levelOrderBottom(outList, root.right, depth);
    }
}

