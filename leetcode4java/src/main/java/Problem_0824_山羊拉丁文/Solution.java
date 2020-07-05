package Problem_0824_山羊拉丁文;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String toGoatLatin(String S) {
        List<String> list = new ArrayList<>(Arrays.asList(S.split(" ")));
        StringBuffer buffer = new StringBuffer("a");
        List<Character> characters = Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u','A','E','I','O','U'});
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            char o = s.charAt(0);
            if (characters.contains(o))
                list.set(i, s + "ma" + buffer.toString());
            else
                list.set(i, s.substring(1, s.length()) + o + "ma" + buffer.toString());
            buffer.append("a");
        }
        StringBuffer resultBuffer = new StringBuffer();
        for (String s : list)
            resultBuffer.append(s + " ");
        return resultBuffer.toString().trim();
    }
}

class Test{
    public static void main(String[] args) {
        String s = new Solution().toGoatLatin("The quick brown fox jumped over the lazy dog");
        System.out.println(s);
    }
}