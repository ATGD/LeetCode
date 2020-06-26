package Problem_5437_不同整数的最少数目;

import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer num = map.get(arr[i]);
            if (num == null)
                num = 0;
            num++;
            map.put(arr[i], num);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = list.size() - 1; i >= 0; i--) {
            if (k > 0) {
                int compare = k - list.get(i).getValue();
                if (compare > 0) {
                    k -= list.get(i).getValue();
                } else if (compare == 0) {
                    return i;
                } else {
                    return i + 1;
                }
            } else {
                return i + 1;
            }
        }
        return 0;
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().findLeastNumOfUniqueInts(new int[]{
                5, 5, 4, 4, 3, 3, 3
        }, 0);
        System.out.println(result);
    }
}