package Problem_0392_判断子序列;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        int tPosition = 0;
        int sPosition = 0;

        while (tPosition < t.length() && sPosition < s.length()) {
            if (s.charAt(sPosition) == t.charAt(tPosition)) {
                sPosition++;
            }
            tPosition++;
        }
        return sPosition == s.length();
    }

    public static void main(String[] args) {
        boolean subsequence = new Solution().isSubsequence("abce", "aeredfgbrhtfhcryrt");
        System.out.println(subsequence);
    }
}

