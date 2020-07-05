package Problem_1160_拼写单词;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCharacters(String[] words, String chars) {
//        int[] table = new int[26];
//        for (int i = 0; i < chars.length(); i++)
//            table[chars.charAt(i) - 'a']++;
//        int result = 0;
//        for (String word : words) {
//            int[] tmpTable = new int[26];
//            for (int i = 0; i < word.length(); i++) {
//                tmpTable[word.charAt(i) - 'a']++;
//            }
//            boolean flagContain = true;
//            for (int i = 0; i < tmpTable.length; i++) {
//                if (tmpTable[i] > table[i]) {
//                    flagContain = false;
//                    break;
//                }
//            }
//            if (flagContain)
//                result += word.length();
//        }
//        return result;
        Map<Character, Integer> tableMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (tableMap.containsKey(c))
                tableMap.put(c, tableMap.get(c) + 1);
            else
                tableMap.put(c, 1);
        }

        int result = 0;
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (wordMap.containsKey(c))
                    wordMap.put(c, wordMap.get(c) + 1);
                else
                    wordMap.put(c, 1);
            }
            boolean contains = true;
            for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
                if (!tableMap.containsKey(entry.getKey()) ||
                        (tableMap.get(entry.getKey()) < entry.getValue())
                ) {
                    contains = false;
                    break;
                }
            }
            if (contains)
                result += word.length();
        }
        return result;
    }
}
