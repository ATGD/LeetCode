package Problem_0804_唯一摩尔斯密码词;

import java.util.*;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseArray = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> morseResult = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char aChar : chars) {
                sb.append(morseArray[aChar - 'a']);
            }
            morseResult.add(sb.toString());
        }
        return morseResult.size();
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        System.out.println(i);
    }
}

