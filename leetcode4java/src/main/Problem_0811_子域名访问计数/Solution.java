package Problem_0811_子域名访问计数;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> cpMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] s1 = cpdomain.split(" ");
            int cpNum = Integer.parseInt(s1[0]);
            String s = s1[1];
            while (s.length() > 0) {
                if (cpMap.containsKey(s)) cpMap.put(s, cpMap.get(s) + cpNum);
                else cpMap.put(s, cpNum);
                int i = s.indexOf(".");
                if (i >= 0) s = s.substring(i + 1);
                else s = "";
            }
        }
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cpMap.entrySet())
            resultList.add(entry.getValue() + " " + entry.getKey());
        return resultList;
    }
}