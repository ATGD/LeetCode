package Problem_5714_替换字符串中的括号内容;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge)
            map.put(strings.get(0), strings.get(1));

        StringBuilder squtBuilder = new StringBuilder(); //括号
        StringBuilder totalBuilder = new StringBuilder();   //整体
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                squtBuilder.append(c);
            } else if (c == ')') {
                String s1 = map.get(squtBuilder.delete(0, 1).toString());
                totalBuilder.append(s1==null?"?":s1);
                squtBuilder.delete(0, squtBuilder.length());
            } else {
                if (squtBuilder.length() != 0) {
                    squtBuilder.append(c);
                } else {
                    totalBuilder.append(c);
                }
            }
        }
        return totalBuilder.toString();
    }
}

class Test {

}