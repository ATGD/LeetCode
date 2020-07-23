package Problem_5465_子树中标签相同的节点数;

import java.util.*;

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> characters0 = map.get(edge[0]);
            if (characters0 == null) characters0 = new ArrayList<>();
            characters0.add(edge[1]);
            map.put(edge[0], characters0);

            List<Integer> characters1 = map.get(edge[1]);
            if (characters1 == null) characters1 = new ArrayList<>();
            characters1.add(edge[0]);
            map.put(edge[1], characters1);
        }

        char[] chars = labels.toCharArray();
        int[] result = new int[n];
        getSameCount(result, map, 0, -1, chars);
        return result;
    }

    private int[] getSameCount(int[] result, Map<Integer, List<Integer>> map, int tempIndex, int head, char[] chars) {
        List<Integer> childNodeList = map.get(tempIndex);
        int[] alpha = new int[26];
        for (int i = 0; i < childNodeList.size(); i++) {
            if (childNodeList.get(i) == head) continue;
            int[] childAplha = getSameCount(result, map, childNodeList.get(i), tempIndex, chars);
            for (int j = 0; j < childAplha.length; j++) {
                int childAlphaCount = childAplha[j];
                alpha[j] += childAlphaCount;
            }
        }
        char tempTag = chars[tempIndex];
        alpha[tempTag - 'a']++;
        result[tempIndex] = alpha[tempTag - 'a'];
        return alpha;
    }
}

class Test {
    public static void main(String[] args) {
        int[] result = new Solution().countSubTrees(
                5,
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {0, 4}},
                "aabab"
        );
        System.out.println(result);
    }
}