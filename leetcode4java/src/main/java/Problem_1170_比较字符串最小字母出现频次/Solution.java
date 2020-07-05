package Problem_1170_比较字符串最小字母出现频次;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        Integer[] wordsInt = new Integer[words.length];
        for (int i = 0; i < words.length; i++)
            wordsInt[i] = countSumNum(words[i]);
        Arrays.sort(wordsInt, (o1, o2) -> {
            return o2 - o1;
        });
        int[] resultInt = new int[queries.length];
        Map<Integer, Integer> cacheMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int compare = countSumNum(queries[i]);
            if (cacheMap.containsKey(compare)) {
                resultInt[i] = cacheMap.get(compare);
                continue;
            }
            int count = 0;
            for (int i1 : wordsInt) {
                if (compare < i1)
                    count++;
                else
                    break;
            }
            resultInt[i] = count;
            cacheMap.put(compare, count);
        }
        return resultInt;
    }

    public int countSumNum(String source) {
        int[] world = new int[26];
        for (int i = 0; i < source.length(); i++)
            world[source.charAt(i) - 'a']++;
        for (int i : world) {
            if (i > 0)
                return i;
        }
        return 0;
    }
}

class TestJ {
    public static void main(String[] args) {
        new Solution().numSmallerByFrequency(new String[]{"bbb", "cc"},
                new String[]{"a", "aa", "aaa", "aaaa"});
    }
}
