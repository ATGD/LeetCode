package Meeting_0037_序列化二叉树;

import ext.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
            list.add(String.valueOf(root.val));
        }
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null) list.add("null");
                else {
                    list.add(String.valueOf(poll.left.val));
                    queue.offer(poll.left);
                }
                if (poll.right == null) list.add("null");
                else {
                    list.add(String.valueOf(poll.right.val));
                    queue.offer(poll.right);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (list.size() != 0) {
            while (list.get(list.size() - 1).equals("null")) list.remove(list.size() - 1);
        }
        for (String s : list) builder.append(s + ",");
        if (list.size() != 0) {
            builder.delete(builder.length() - 1, builder.length());
        }
        builder.append("]");
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        if (data == null || data.equals("")) return null;
        if (split.length == 0) return null;
        if (split[0].equals("null")) return null;
        TreeNode head = new TreeNode(Integer.parseInt(split[0]));
        queue.add(head);
        int index = 1;
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (index >= split.length) return head;
                if (!split[index].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(split[index]));
                    node.left = left;
                    queue.offer(left);
                }
                index++;
                if (index >= split.length) return head;
                if (!split[index].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(split[index]));
                    node.right = right;
                    queue.offer(right);
                }
                index++;
            }
        }
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

class Test {

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode treeNode = codec.deserialize("[]");
        System.out.println(treeNode);
        String serialize = codec.serialize(treeNode);
        System.out.println(serialize);
    }
}