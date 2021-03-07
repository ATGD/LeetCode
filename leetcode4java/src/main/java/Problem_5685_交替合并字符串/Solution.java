package Problem_5685_交替合并字符串;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int commonLength = Math.min(word1.length(), word2.length());

        String extra = "";

        if (word1.length() < word2.length()) {
            extra = word2.substring(commonLength);
        } else {
            extra = word1.substring(commonLength);
        }
        StringBuffer mergedSB = new StringBuffer();
        for (int i = 0; i < commonLength; i++) {
            mergedSB.append(word1.charAt(i));
            mergedSB.append(word2.charAt(i));
        }
        mergedSB.append(extra);
        return mergedSB.toString();
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().mergeAlternately("adfasdf", "");
        System.out.println(s);
    }
}