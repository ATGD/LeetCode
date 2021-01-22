package Problem_5603_确定两个字符串是否接近;

import java.util.AbstractMap;
import java.util.Map;

class Solution {

    Map.Entry<Character, Integer>[] words1 = new Map.Entry[26];
    Map.Entry<Character, Integer>[] words2 = new Map.Entry[26];

    public boolean closeStrings(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            Map.Entry<Character, Integer> entry = words1[c - 'a'];
            if (entry == null) {
                entry = new AbstractMap.SimpleEntry<>(c, 0);
                words1[c - 'a'] = entry;
            } else {
                entry.setValue(entry.getValue() + 1);
            }
        }
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            Map.Entry<Character, Integer> entry = words2[c - 'a'];
            if (entry == null) {
                entry = new AbstractMap.SimpleEntry<>(c, 0);
                words2[c - 'a'] = entry;
            } else {
                entry.setValue(entry.getValue() + 1);
            }
        }
        return false;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */