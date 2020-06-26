package Problem_1010_总持续时间可被60整除的歌曲;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {
    public int numPairsDivisibleBy60Map(int[] time) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int value = time[i] % 60;
            Integer integer = valueMap.get(value);
            if (integer == null) {
                valueMap.put(value, 1);
            } else {
                valueMap.put(value, integer + 1);
            }
        }
        int count = 0;
        Set<Map.Entry<Integer, Integer>> entries = valueMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            int key = next.getKey();
            int value = next.getValue();
            if (key == 30 ||
                    key == 0) {
                for (int i = 0; i < value - 1; i++) {
                    for (int j = i + 1; j < value; j++) {
                        count++;
                    }
                }
            } else if (key < 30) {
                Integer integer = valueMap.get(60 - key);
                if (integer != null) {
                    count += value * integer;
                }
            }
        }
        return count;
    }

    public int numPairsDivisibleBy60Array(int[] time) {
        int[] minuteArray = new int[60];
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            int minuteDivide60 = time[i] % 60;
            count += minuteArray[(60 - minuteDivide60) % 60];
            minuteArray[minuteDivide60]++;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {

        int i = new Solution().numPairsDivisibleBy60Array(new int[]{
                30, 20, 150, 100, 40
        });
        System.out.println(i);
    }
}

