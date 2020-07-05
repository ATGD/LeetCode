package Problem_5319_删除回文子序列;


class Solution {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = 0, end = s.length() - 1;
        while (start < end) if (s.charAt(start++) != s.charAt(end--)) return 2;
        return 1;
    }
}

class Test {
    public static void main(String[] args) {
    }
}
