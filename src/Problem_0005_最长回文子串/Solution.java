package Problem_0005_最长回文子串;

import java.util.HashMap;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    boolean isPalindrome = true;
                    int tempLeft = i;
                    int tempRight = j;
                    int length = j - i + 1;
                    if (length % 2 == 1) {
                        while ((tempRight - tempLeft) != 2) {
                            tempLeft++;
                            tempRight--;
                            if (s.charAt(tempLeft) != s.charAt(tempRight)) {
                                isPalindrome = false;
                                break;
                            }
                        }
                    } else {
                        while ((tempRight - tempLeft) != 1) {
                            tempLeft++;
                            tempRight--;
                            if (s.charAt(tempLeft) != s.charAt(tempRight)) {
                                isPalindrome = false;
                                break;
                            }
                        }
                    }
                    if ((length > max) && isPalindrome) {
                        start = i;
                        end = j;
                        max = length;
                        if (max == s.length()) {
                            return s;
                        }
                    }
                }
            }
        }
        if (max == 0) {
            return s.substring(0, 1);
        }
        return s.substring(start, end + 1);
    }
}

