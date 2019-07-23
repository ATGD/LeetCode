package Problem_1078_Bigram分词;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        List<String> findList = new ArrayList<>();
        if (s.length <= 2) {
            return new String[0];
        }
        for (int i = 1; i < s.length; i++) {
            String indexStr = s[i];
            if (indexStr.equals(second) && s[i - 1].equals(first)) {
                if (i + 1 < s.length) {
                    findList.add(s[i + 1]);
                }
            }
        }
        String[] returnArray = new String[findList.size()];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = findList.get(i);
        }
        return returnArray;
    }
}

class Text {
    public static void main(String[] args) {
        String[] ocurrences = new Solution().findOcurrences("alice is a good girl she is a good student", "a", "good");
        System.out.println(ocurrences);
    }
}

