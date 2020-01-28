package Problem_0496_下一个更大元素1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++)
            map.put(nums2[i], i);
        int[] results = new int[nums1.length];
        for (int i = 0; i < results.length; i++) {
            int integer = map.get(nums1[i]) + 1;
            boolean find = false;
            while (integer < nums2.length) {
                if (nums2[integer] > nums1[i]) {
                    results[i] = nums2[integer];
                    find = true;
                    break;
                }
                integer++;
            }
            if (!find) {
                results[i] = -1;
            }
        }
        return results;
    }
}