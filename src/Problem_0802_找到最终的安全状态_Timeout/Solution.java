package Problem_0802_找到最终的安全状态_Timeout;

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, List<Integer>> rodeMap = new HashMap<>();
        Set<Integer> deadSet = new HashSet<>();
        List<Integer> freeList = new ArrayList<>();
        Set<Integer> freeSet = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> rodeList = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                rodeList.add(graph[i][j]);
            }
            rodeMap.put(i, rodeList);
            if (rodeList.isEmpty()) {
                freeSet.add(i);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            Set<Integer> linkedSet = new HashSet<>();
            boolean deadNode = isDeadNode(i, linkedSet, rodeMap, deadSet, freeSet);
            if (!deadNode) {
                freeSet.add(i);
            }
        }
        freeList.addAll(freeSet);
        Collections.sort(freeList);
        return freeList;
    }

    private boolean isDeadNode(int i, Set<Integer> linkedSet, Map<Integer, List<Integer>> rodeMap, Set<Integer> deadSet, Set<Integer> freeList) {
        if (deadSet.contains(i))
            return true;
        if (linkedSet.contains(i))
            return true;
        List<Integer> integers = rodeMap.get(i);
        for (int j = 0; j < integers.size(); j++) {
            if (deadSet.contains(integers.get(j))) {
                deadSet.add(i);
                for (Integer integer : linkedSet) {
                    deadSet.add(integer);
                }
                return true;
            } else {
                Set<Integer> tempSet = new HashSet<>(linkedSet);
                tempSet.add(i);
                if (!freeList.contains(integers.get(j))) {
                    boolean deadNode = isDeadNode(integers.get(j), tempSet, rodeMap, deadSet, freeList);
                    if (deadNode) {
                        deadSet.add(i);
                        deadSet.add(integers.get(j));
                        for (Integer integer : linkedSet) {
                            deadSet.add(integer);
                        }
                        return deadNode;
                    }
                }
            }
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        List<Integer> integers = new Solution().eventualSafeNodes(input);
        System.out.println(integers);
    }
}

