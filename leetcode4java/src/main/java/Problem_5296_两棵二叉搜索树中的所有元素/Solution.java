package Problem_5296_两棵二叉搜索树中的所有元素;

import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> resultList = new LinkedList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getMidAll(list1, root1);
        getMidAll(list2, root2);
        int pointer1 = 0;
        int pointer2 = 0;
        while ((pointer1 < list1.size()) ||
                (pointer2 < list2.size())) {
            if (pointer1 >= list1.size())
                resultList.add(list2.get(pointer2++));
            else if (pointer2 >= list2.size())
                resultList.add(list1.get(pointer1++));
            else {
                if (list1.get(pointer1) <= list2.get(pointer2))
                    resultList.add(list1.get(pointer1++));
                else
                    resultList.add(list2.get(pointer2++));
            }
        }
        return resultList;
    }

    void getMidAll(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        getMidAll(list, root.left);
        list.add(root.val);
        getMidAll(list, root.right);
    }
}
