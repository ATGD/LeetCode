package Problem_5478_最大得分;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Long[] memo;

    public int maxSum(int[] nums1, int[] nums2) {
        memo = new Long[Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]) + 1];
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) map1.put(nums1[i], i);
        for (int i = 0; i < nums2.length; i++) map2.put(nums2[i], i);
        long result1 = getMaxSum(map1, map2, 0, true, nums1, nums2);
        long result2 = getMaxSum(map1, map2, 0, false, nums1, nums2);
        return (int) (Math.max(result1, result2)%1000000007);
    }

    /**
     * @param map1
     * @param map2
     * @param index
     * @param isFirst
     * @param nums1
     * @param nums2
     * @return
     */
    private long getMaxSum(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int index, boolean isFirst, int[] nums1, int[] nums2) {

        if (isFirst) {
            if (index >= nums1.length) return 0;
            if (memo[nums1[index]] != null) return memo[nums1[index]];
            long result = getMaxSum(map1, map2, index + 1, isFirst, nums1, nums2);
            if (map2.containsKey(nums1[index])) {
                result = Math.max(result, getMaxSum(map1, map2, map2.get(nums1[index]) + 1, !isFirst, nums1, nums2));
            }
            return memo[nums1[index]] = result + nums1[index];
        } else {
            if (index >= nums2.length) return 0;
            if (memo[nums2[index]] != null) return memo[nums2[index]];
            long result = getMaxSum(map1, map2, index + 1, isFirst, nums1, nums2);
            if (map1.containsKey(nums2[index])) {
                result = Math.max(result, getMaxSum(map1, map2, map1.get(nums2[index]) + 1, !isFirst, nums1, nums2));
            }
            return memo[nums2[index]] = result + nums2[index];
        }
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxSum(
                new int[]{
                        1,4,5,8,9,11,19
                },
                new int[]{
                        2,3,4,11,12
                }
        );
        System.out.println(i);
    }
}