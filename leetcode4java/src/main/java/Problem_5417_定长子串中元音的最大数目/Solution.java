package Problem_5417_定长子串中元音的最大数目;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        String tempStr = s.substring(0, k);
        int tempMax = 0;
        int resultMax = 0;
        for (int i = 0; i < tempStr.length(); i++) {
            if (set.contains(tempStr.charAt(i))) tempMax++;
        }
        resultMax = tempMax;
        if (tempMax == k || s.length() <= k) return tempMax;
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i - k))) tempMax--;
            if (set.contains(s.charAt(i))) tempMax++;
            resultMax = Math.max(resultMax, tempMax);
            if (resultMax == k) return resultMax;
        }
        return resultMax;
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().maxVowels("abciiidef", 3);
        System.out.println(result);
    }
}