package Problem_0884_两句话中的不常见单词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] s1 = A.split(" ");
        String[] s2 = B.split(" ");
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        for (String s : s1)
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        for (String s : s2)
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() < 2 && !map2.containsKey(entry.getKey()))
                resultList.add(entry.getKey());
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (entry.getValue() < 2 && !map1.containsKey(entry.getKey()))
                resultList.add(entry.getKey());
        }
        return resultList.toArray(new String[resultList.size()]);
    }
}

