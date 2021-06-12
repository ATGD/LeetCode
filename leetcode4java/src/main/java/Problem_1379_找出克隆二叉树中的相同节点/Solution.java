package Problem_1379_找出克隆二叉树中的相同节点;

import ext.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        List<Integer> rouds = new ArrayList<>();
        findNode(rouds, original, target);
        Iterator<Integer> iterator = rouds.iterator();

        TreeNode result = cloned;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 0) {
                result = result.left;
            } else {
                result = result.right;
            }
        }
        return result;
    }

    private boolean findNode(List<Integer> rouds, TreeNode node, TreeNode target) {
        if (node == null)
            return false;
        if (node == target)
            return true;

        boolean result = false;
        rouds.add(0);
        if (findNode(rouds, node.left, target))
            return true;
        rouds.remove(rouds.size() - 1);
        rouds.add(1);
        if (findNode(rouds, node.right, target))
            return true;
        rouds.remove(rouds.size() - 1);
        return false;
    }
}