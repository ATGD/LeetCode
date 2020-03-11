package ext;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode makeTreeNode(Object[] nodes) {
        if (nodes == null || nodes.length == 0) return null;
        return makeTreeNode(nodes, 0);
    }

    private static TreeNode makeTreeNode(Object[] nodes, int position) {
        if (nodes[position] == null) return null;
        TreeNode treeNode = new TreeNode((Integer) nodes[position]);
        if (position * 2 + 1 < nodes.length) {
            treeNode.left = makeTreeNode(nodes, position * 2 + 1);
        }
        if (position * 2 + 2 < nodes.length) {
            treeNode.right = makeTreeNode(nodes, position * 2 + 2);
        }
        return treeNode;
    }

}
