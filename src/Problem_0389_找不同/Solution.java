package Problem_0389_找不同;

class Solution {
    public char findTheDifference(String s, String t) {
        char[] alpha = new char[26];
        for (int i = 0; i < s.length(); i++) alpha[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (alpha[t.charAt(i) - 'a']-- == 0) {
                return t.charAt(i);
            }
        }
        return 0;
    }
}
