package Problem_5316_竖直打印单词;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> printVertically(String s) {
        String[] s1 = s.split(" ");
        List<String> resultList = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < s1.length; i++) {
            maxLength = Math.max(s1[i].length(), maxLength);
        }
        int index = 0;
        //i表示应该输出的第几个竖直单词
        for (int i = 0; i < maxLength; i++) {
            StringBuffer buffer = new StringBuffer();
            //j表示第几个分割单词
            for (int j = 0; j < s1.length; j++) {
                if (i >= s1[j].length()) {
                    buffer.append(" ");
                } else {
                    buffer.append(s1[j].charAt(i));
                }
            }
            String s2 = buffer.toString();
            while (s2.charAt(s2.length() - 1) == ' ') {
                s2 = s2.substring(0, s2.length() - 1);
            }
            resultList.add(s2);
        }
        return resultList;
    }
}

class Test {
    public static void main(String[] args) {
        List<String> strings = new Solution().printVertically("TO BE OR NOT TO BE");
        System.out.println(strings);
    }
}
