package Problem_5188_树节点的第K个祖先;

import java.util.HashMap;
import java.util.Map;

class TreeAncestor {

    private int[] tree;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeAncestor(int n, int[] parent) {
        tree = new int[n];
        for (int i = 0; i < parent.length; i++) {
            tree[i] = parent[i];
            if (tree[i] == -1) {
                map.put(i, 0);
            } else {
                Integer parentDeep = map.get(tree[i]);
                if (parentDeep != null) {
                    map.put(i, parentDeep + 1);
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        while (k > 0) {
            int parent = tree[node];
            if (parent == -1) return -1;
            else node = parent;
            k--;
        }
        return node;
    }
}

class Test {
    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{
                -1, 0, 0, 1, 1, 2, 2
        });
        int result1 = treeAncestor.getKthAncestor(3, 1);
        int result2 = treeAncestor.getKthAncestor(5, 2);
        int result3 = treeAncestor.getKthAncestor(6, 3);
        System.out.println("finish");
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
