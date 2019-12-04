package Problem_1046_最后一块石头的重量;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int lastStoneWeight(int[] stones) {

        List<Integer> stoneList = new ArrayList<>();
        for(int item : stones) {
            stoneList.add(item);
        }
        Collections.sort(stoneList);
        while (stoneList.size() > 1) {
            Integer big = stoneList.remove(stoneList.size() - 1);
            Integer small = stoneList.remove(stoneList.size() - 1);
            if (big == small) {
            } else {
                stoneList.add(big - small);
                Collections.sort(stoneList);
            }
        }
        if (stoneList.size() == 1) {
            return stoneList.get(0);
        } else {
            return 0;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().lastStoneWeight(new int[]{394, 63, 237, 556, 35, 843, 34, 842});
        System.out.println(i);
    }
}

