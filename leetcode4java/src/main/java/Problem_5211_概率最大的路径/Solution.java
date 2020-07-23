package Problem_5211_概率最大的路径;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<Entry, Integer> indexMap = new HashMap<>();

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Entry[] point = new Entry[n];
        for (int i = 0; i < point.length; i++) {
            point[i] = new Entry();
            indexMap.put(point[i], i);
        }
        for (int i = 0; i < edges.length; i++) {
            int pointIndex1 = edges[i][0];
            int pointIndex2 = edges[i][1];
            double thisSuccProb = succProb[i];
            point[pointIndex1].map.put(point[pointIndex2], thisSuccProb);
            point[pointIndex2].map.put(point[pointIndex1], thisSuccProb);
        }
        memo = new Double[n][n];
        return findMin(point[start], point[end], new HashSet<>());
    }

    Double[][] memo;

    private Double findMin(Entry entry1, Entry entry2, Set<Entry> path) {
        Double result = memo[indexMap.get(entry1)][indexMap.get(entry2)];
        if (result != null) return result;
        result = memo[indexMap.get(entry2)][indexMap.get(entry1)];
        if (result != null) return result;
        Set<Map.Entry<Entry, Double>> entries = entry1.map.entrySet();
        for (Map.Entry<Entry, Double> entry : entries) {
            if (path.contains(entry.getKey())) continue;
            path.add(entry.getKey());
            Double min = findMin(entry.getKey(), entry2, path);
            if (min != null) {
                if (result == null) result = min * entry.getValue();
                else result = Math.min(result, min * entry.getValue());
            }
            path.remove(entry.getKey());
        }
        memo[indexMap.get(entry2)][indexMap.get(entry1)] = result;
        memo[indexMap.get(entry1)][indexMap.get(entry2)] = result;
        return memo[indexMap.get(entry2)][indexMap.get(entry1)];
    }

    class Entry {
        Map<Entry, Double> map = new HashMap<>();
    }
}

class Test {
    public static void main(String[] args) {
        double v = new Solution().maxProbability(
                3,
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {0, 2}
                },
                new double[]{0.5, 0.5, 0.2},
                0,
                2);
        System.out.println(v);
    }
}
