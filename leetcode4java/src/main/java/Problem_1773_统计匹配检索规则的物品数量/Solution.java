package Problem_1773_统计匹配检索规则的物品数量;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;

        Map<String,Integer> map = new HashMap<>((int)(3f/0.75 + 1));
        map.put("type",0);
        map.put("color",1);
        map.put("name",2);

        int ruleIndex = map.get(ruleKey);

        for (List<String> item : items) {
            if (item.get(ruleIndex).equals(ruleValue))
                count++;
        }
        return count;
    }
}