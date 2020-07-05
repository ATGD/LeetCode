package Problem_0680_验证回文字符串2;

class Solution {

    char[] chars;

    public boolean validPalindrome(String s) {
        if (s == null) return false;
        chars = s.toCharArray();
        return validPalindrome(false, 0, chars.length - 1);
    }

    public boolean validPalindrome(boolean hasConsume, int start, int end) {
        if (start >= end) return true;
        if (hasConsume) {
            if (chars[start] != chars[end])
                return false;
            return validPalindrome(true, start + 1, end - 1);
        } else {
            if (chars[start] != chars[end])
                return validPalindrome(true, start + 1, end) || validPalindrome(true, start, end - 1);
            else
                return validPalindrome(false, start + 1, end - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        boolean result = new Solution().validPalindrome("abcdefghgfeeedcba");
        System.out.println(result);
    }
}