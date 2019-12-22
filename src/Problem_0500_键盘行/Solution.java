package Problem_0500_键盘行;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        List<String> resultList = new ArrayList<>();
        char[] chars1 = "qwertyuiop".toCharArray();
        char[] chars2 = "asdfghjkl".toCharArray();
        for (String word : words) {
            String smallChar = word.toLowerCase();
            int state = getState(chars1, chars2, smallChar.charAt(0));
            if (smallChar.length() == 1) resultList.add(word);
            for (int i = 1; i < word.toCharArray().length; i++) {
                int tmpState = getState(chars1, chars2, smallChar.charAt(i));
                if (tmpState != state) break;
                if (i == word.length() - 1) resultList.add(word);
            }
        }
        return resultList.toArray(new String[resultList.size()]);
    }

    private int getState(char[] chars1, char[] chars2, char word) {
        for (char c : chars1) if (c == word) return 1;
        for (char c : chars2) if (c == word) return 2;
        return 3;
    }
}

class Test {
    public static void main(String[] args) {
        String[] words = new Solution().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        System.out.println(words);
    }
}