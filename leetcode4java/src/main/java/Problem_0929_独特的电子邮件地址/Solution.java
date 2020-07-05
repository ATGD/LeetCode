package Problem_0929_独特的电子邮件地址;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> addressSet = new HashSet<>();
        for (String email : emails) {
            StringBuffer sb = new StringBuffer();
            char[] chars = email.toCharArray();
            int state = 0;//0为刚开始，1为有加号，2为有@，之后都要添加
            for (char aChar : chars) {
                if (state == 0) {
                    if (aChar == '.')
                        continue;
                    else if (aChar == '+')
                        state = 1;
                    else if (aChar == '@') {
                        state = 2;
                        sb.append(aChar);
                    } else
                        sb.append(aChar);
                } else if (state == 1) {
                    if (aChar == '@') {
                        state = 2;
                        sb.append(aChar);
                    }
                } else
                    sb.append(aChar);
            }
            System.out.println(sb.toString());
            addressSet.add(sb.toString());
        }
        return addressSet.size();
    }
}


