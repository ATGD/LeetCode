package Problem_5243_同积元组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //1,2,3,4,5,6,7
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> rcnts = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int pro = nums[i] * nums[j];
                ans += rcnts.getOrDefault(pro, 0);
                rcnts.put(pro, rcnts.getOrDefault(pro, 0) + 1);
            }
        }
        return ans * 8;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().tupleSameProduct(new int[]{2, 3, 4, 6});
        System.out.println(i);
    }
}

