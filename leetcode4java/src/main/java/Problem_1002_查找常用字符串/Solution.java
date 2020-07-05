package Problem_1002_查找常用字符串;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] A) {
        int[] lettersArray = new int[26];
        for (int i = 0; i < A.length; i++) {
            String tempStr = A[i];
            int[] tempArray = new int[26];
            for (int i1 = 0; i1 < tempStr.length(); i1++) {
                if (i == 0) {
                    lettersArray[tempStr.charAt(i1) - 'a']++;
                } else {
                    tempArray[tempStr.charAt(i1) - 'a']++;
                }
            }
            if (i != 0) {
                for (int i1 = 0; i1 < lettersArray.length; i1++) {
                    lettersArray[i1] = Math.min(lettersArray[i1], tempArray[i1]);
                }
            }
        }
        List<String> commonmList = new ArrayList<>();
        for (int i = 0; i < lettersArray.length; i++) {
            for (int integer = 0; integer < lettersArray[i]; integer++) {
                commonmList.add((char) ('a' + i) + "");
            }
        }
        return commonmList;
    }
}

class Test {
    public static void main(String[] args) {
        List<String> strings = new Solution().commonChars(new String[]{
                "cool","lock","cook"
        });
        System.out.println(strings);
    }
}

