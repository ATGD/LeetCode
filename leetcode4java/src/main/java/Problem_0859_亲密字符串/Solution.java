package Problem_0859_亲密字符串;

class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int firstIndex = -1;
        int lastIndex = -1;
        int[] words = new int[26];
        boolean hasSame = false;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (firstIndex == -1)
                    firstIndex = i;
                else if (lastIndex == -1)
                    lastIndex = i;
                else
                    return false;
            }
            if (!hasSame) {
                int index = A.charAt(i) - 'a';
                words[index]++;
                if (words[index] > 1)
                    hasSame = true;
            }
        }
        if (firstIndex == -1 || lastIndex == -1) {
            return hasSame;
        } else return A.charAt(firstIndex) == B.charAt(lastIndex)
                && A.charAt(lastIndex) == B.charAt(firstIndex);
    }
}

class Test{
    public static void main(String[] args) {
        boolean b = new Solution().buddyStrings("aa", "aa");
    }
}