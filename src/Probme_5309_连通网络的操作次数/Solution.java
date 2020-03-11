package Probme_5309_连通网络的操作次数;

import java.util.HashSet;
import java.util.Set;

class Solution {
    // 路径压缩的并查集模板
    int[] id;
    int[] sz;

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] = sz[j];
        }
    }

    public void initUF(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        initUF(n);
        // 多余的线缆数量
        int cnt = 0;
        for (int[] c : connections) {
            int f = c[0], t = c[1];
            // 两个点已经连通，不需要这个线缆
            if (find(f) == find(t)) {
                cnt += 1;
                continue;
            }
            union(f, t);
        }
        // 查找一共有几个连通的区域，即一共有几个祖先节点
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        // 所需要的线缆数量
        int cnt2 = set.size() - 1;
        if (cnt < cnt2) {
            return -1;
        }
        return cnt2;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(8+(~3)));
    }
}



