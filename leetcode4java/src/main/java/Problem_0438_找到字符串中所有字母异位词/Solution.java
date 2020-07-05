package Problem_0438_找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> findAnms = new ArrayList<>();
        if (s.length() < p.length()) {
            return findAnms;
        }
        int[] pChars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pChars[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] sChars = new int[26];
            int notIndexMax = -1;
            for (int i1 = i; i1 < i + p.length(); i1++) {
                if (p.indexOf(s.charAt(i1)) == -1) {
                    if (i1 > notIndexMax) {
                        notIndexMax = i1;
                    }
                }
                sChars[s.charAt(i1) - 'a']++;
            }
            if (notIndexMax != -1) {
                i = notIndexMax;
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < pChars.length; j++) {
                if (pChars[j] != sChars[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                findAnms.add(i);
            }
        }
        return findAnms;
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> anagrams = new Solution().findAnagrams("abceebacdabc", "abc");
        System.out.println(anagrams);
    }
}

