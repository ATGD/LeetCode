package Problem_5347_使网格图至少有一条有效路径的最小代价;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    final int dx[] = {0, 1, -1, 0, 0};
    final int dy[] = {0, 0, 0, 1, -1};

    public int minCost(int[][] grid) {
//        int n = grid.length, m = grid[0].length;
//        List<List<Integer>> dist = new ArrayList<>();
//        ArrayList<Integer> _0List = new ArrayList<>();
//        _0List.add(0);
//        dist.add(_0List);
//        PriorityQueue<Pair, List<Pair>> pq;
//        pq.push(make_pair(0, 0));
//        vector<bool> vis (n * m);
//        while (!pq.empty()) {
//            pii f = pq.top();
//            pq.pop();
//            if (vis[f.second]) continue;
//            vis[f.second] = true;
//            int y = f.second / m, x = f.second % m;
//            for (int k = 1; k <= 4; ++k) {
//                int nx = x + dx[k], ny = y + dy[k];
//                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
//                    continue;
//                int nd = f.first + (grid[y][x] == k ? 0 : 1);
//                if (nd < dist.get(ny).get(nx)) {
//                    dist.get(ny).set(nx, nd);
//                    pq.push(make_pair(dist[ny][nx], ny * m + nx));
//                }
//            }
//        }
//        return dist.get(n - 1).get(m - 1);
        return 1;
    }

    class Pair{
        int a;
        int b;
    }
}