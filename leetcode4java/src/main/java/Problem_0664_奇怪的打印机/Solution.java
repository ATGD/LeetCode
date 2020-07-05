package Problem_0664_奇怪的打印机;

class Solution {
    public int strangePrinter(String s) {
        return dp(s, 0, s.length() - 1);
    }

    private int dp(String s, int start, int end) {
        if (s == null || s.length() == 0) return 0;
        if (start >= s.length() || end >= s.length()) return 0;
        if (start > end) return 0;
        char c = s.charAt(start);
        int lastCIndex = s.lastIndexOf(c);
        int charFindStart = start;
        int charFindEnd = lastCIndex;
        while (charFindStart < charFindEnd) {
            if (s.charAt(charFindStart) != c)
                break;
            charFindStart++;
        }
        while (charFindStart < charFindEnd) {
            if (s.charAt(charFindEnd) != c)
                break;
            charFindEnd--;
        }
        if (charFindStart == charFindEnd) {
            return 1 + dp(s, charFindStart + 1, end);
        } else
            return 1 + dp(s, charFindStart + 1, charFindEnd - 1) + dp(s, lastCIndex + 1, end);
    }
}

class Test {
    public static void main(String[] args) {
        int num = new Solution().strangePrinter("aabbccaabb");
        //"aaaaaaaa"
        //"aaaaaaaabb"
        //"aabbaaaabb"
        //"aabbccaabb"
        System.out.println(num);
    }
}

