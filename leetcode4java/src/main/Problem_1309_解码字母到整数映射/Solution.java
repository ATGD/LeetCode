package Problem_1309_解码字母到整数映射;


import java.util.HashMap;
import java.util.Map;

class Solution {
    private char[] a = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private String[] b = {"10#", "11#", "12#", "13#", "14#", "15#", "16#", "17#", "18#", "19#", "20#", "21#", "22#", "23#", "24#", "25#", "26#"};

    public String freqAlphabets(String s) {
        char[] chars = s.toCharArray();
        StringBuffer buffer = new StringBuffer();
        Map<String, String> resultMap = new HashMap<>();
        for (int i = 0; i < chars.length; ) {
            if (chars[i] <= 2 && (i + 2) < chars.length && chars[i + 2] == '#') {
                String match = "" + chars[i] + chars[i + 1] + "#";
                for (int j = 0; j < b.length; j++) {
                    if (b[j].equals(match)) {
                        buffer.append(((char) ('j' + j)));
                        break;
                    }
                }
                i += 2;
            } else {
                for (int j = 0; j < a.length; j++) {
                    if (a[j] == chars[i]) {
                        buffer.append(((char) ('a' + j)));
                        break;
                    }
                }
                i++;
            }
        }
        return buffer.toString();
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#");
        System.out.println(s);
    }
}
