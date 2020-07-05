package Problem_0043_字符串相乘;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String multiply(String num1, String num2) {
        List<String> totalNums = new ArrayList<>();
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int i1 = Integer.parseInt(num1.charAt(i) + "");
                int i2 = Integer.parseInt(num2.charAt(j) + "");
                int i3 = i1 * i2;
                StringBuffer sb = new StringBuffer(i3 + "");
                for (int k = 0; k < num1.length() - i + num2.length() - j - 2; k++) {
                    sb.append(0);
                }
                totalNums.add(sb.toString());
            }
        }

        return null;
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            stringBuffer.append(i + "", 0, 1);
        }
        System.out.println(stringBuffer.toString());
    }
}

