package Problem_0076_最小覆盖子串;

import java.util.*;

class Solution {
    int totalShouldCount = 0;

    public String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer tmpCount = targetMap.get(c);
            targetMap.put(c, tmpCount == null ? 1 : tmpCount + 1);
            totalShouldCount++;
        }
        Map<Character, List<Integer>> sourceMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            char c = source[i];
            if (targetMap.containsKey(c)) {
                queue.add(i);
                List<Integer> targetElementList = sourceMap.get(c);
                if (targetElementList == null) targetElementList = new ArrayList<>();
                targetElementList.add(i);
                sourceMap.put(c, targetElementList);
                if (sourceMap.containsKey(c)) {
                    while (true) {
                        List<Integer> sourceElementList = sourceMap.get(s.charAt(queue.peek()));
                        if (sourceElementList.size() > targetMap.get(s.charAt(queue.peek()))) {
                            queue.remove();
                        } else break;
                    }

                }
                if (getMapTotalLength(sourceMap, targetMap)) {
                    Integer start = queue.peek();
                    if (result == "" || result.length() > i - start) {
                        result = s.substring(start, i + 1);
                    }
                }
            }
        }
        return result;
    }

    private boolean getMapTotalLength(Map<Character, List<Integer>> sourceMap, Map<Character, Integer> targetMap) {
        if (sourceMap.size() != targetMap.size()) return false;
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            List<Integer> sourceList = sourceMap.get(entry.getKey());
            if (sourceList == null || sourceList.size() < entry.getValue())
                return false;
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        String result = new Solution().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }
}

