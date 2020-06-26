package Problem_0005_最长回文子串;


class Solution {
    private Integer[][] memo;
    private String longest = "";

    public String longestPalindrome(String s) {
        memo = new Integer[s.length()][s.length()];
        longestPalindrome(s, 0, s.length() - 1);
        return longest;
    }

    private int longestPalindrome(String s, int start, int end) {
        if (start > end) return 0;
        if (start == end) {
            compareStr(s, start, end);
            return 1;
        }
        if (memo[start][end] != null) return memo[start][end];
        if (s.charAt(start) == s.charAt(end) &&
                longestPalindrome(s, start + 1, end - 1) == (end - start - 1)
        ) {
            memo[start][end] = end - start + 1;
            compareStr(s, start, end);
        } else {
            int result1 = longestPalindrome(s, start + 1, end);
            int result2 = longestPalindrome(s, start, end - 1);
            memo[start][end] = Math.max(result1, result2);
        }
        return memo[start][end];
    }

    private void compareStr(String s, int start, int end) {
        if (end - start + 1 > longest.length()) longest = s.substring(start, end + 1);
    }
}

class Test {
    public static void main(String[] args) {
        String result = new Solution().longestPalindrome("kasjdfkjasdfababababababaaskdjfklasdjfka");
        System.out.println(result);
    }
}

