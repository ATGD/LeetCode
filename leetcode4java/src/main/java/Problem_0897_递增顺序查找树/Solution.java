package Problem_0897_递增顺序查找树;

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
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        makeBST_List(list, root);
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).left = null;
            list.get(i - 1).right = list.get(i);
            list.get(i).left = null;
            list.get(i).right = null;
        }
        return list.get(0);
    }

    public void makeBST_List(List<TreeNode> list, TreeNode treeNode) {
        if (treeNode == null) return;
        makeBST_List(list, treeNode.left);
        list.add(treeNode);
        makeBST_List(list, treeNode.right);
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(0);
        treeNode.left = treeNode1;
        TreeNode treeNode2 = new Solution().increasingBST(treeNode);
        System.out.println(treeNode2);
    }
}