package Problem_0914_卡牌分组;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {
    //3,6,9
    int maxDiv = -1;

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> deckMap = new HashMap<>();
        for (int i : deck) {
            Integer itemCount = deckMap.get(i);
            if (itemCount == null) itemCount = 0;
            itemCount += 1;
            deckMap.put(i, itemCount);
        }
        Set<Map.Entry<Integer, Integer>> entries = deckMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            if (maxDiv == -1) maxDiv = iterator.next().getValue();
            else maxDiv = countMaxDiv(maxDiv, iterator.next().getValue());
            if (maxDiv == 1) return false;
        }
        return maxDiv >= 2;
    }

    private int countMaxDiv(int x, int y) {
        if (x == 0) return y;
        return countMaxDiv(y % x, x);
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().hasGroupsSizeX(new int[]{
                0, 0, 0, 0, 0, 1, 1, 1
        });
        System.out.println(b);
    }
}
