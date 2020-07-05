package Meeting_0026_树的子结构;

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        List<TreeNode> list = new ArrayList<>(1000);
        findHead(list, A, B.val);
        for (int i = 0; i < list.size(); i++) if (hasStruct(list.get(i), B)) return true;
        return false;
    }

    private boolean hasStruct(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return hasStruct(a.left, b.left) && hasStruct(a.right, b.right);
    }

    private void findHead(List<TreeNode> list, TreeNode a, int val) {
        if (a == null) return;
        if (a.val == val) list.add(a);
        findHead(list, a.left, val);
        findHead(list, a.right, val);
    }
}