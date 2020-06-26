package Problem_0748_最短完整单词;

import java.util.Arrays;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] chars = licensePlate.toLowerCase().toCharArray();
        Arrays.sort(chars);
        int minLength = Integer.MAX_VALUE;
        String matchWord = null;
        for (String word : words) {
            char[] charTemp = word.toLowerCase().toCharArray();
            Arrays.sort(charTemp);
            int indexLicense = 0;
            int indexWord = 0;
            boolean flag = false;
            while ((indexLicense < chars.length) && (indexWord < charTemp.length)) {
                if (!Character.isLetter(chars[indexLicense])) {
                    indexLicense++;
                } else if (charTemp[indexWord] == chars[indexLicense]) {
                    indexLicense++;
                    indexWord++;
                    if (indexLicense == chars.length) {
                        flag = true;
                        break;
                    }
                } else {
                    indexWord++;
                }
            }
            if (flag) {
                if (word.length() < minLength) {
                    minLength = word.length();
                    matchWord = word;
                }
            }
        }
        return matchWord;
    }
}

class Test {
    public static void main(String[] args) {
        String out = new Solution().shortestCompletingWord("1s3 456", new String[]{
                "looks","pest","stew","show"
        });
        System.out.println(out
        );
    }
}



