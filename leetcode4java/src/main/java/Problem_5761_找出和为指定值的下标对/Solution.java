package Problem_5761_找出和为指定值的下标对;

import java.util.*;

class FindSumPairs {

    Map<Integer, Integer> valueCountMap = new HashMap<>();
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int i = 0; i < nums2.length; i++) {
            Integer integer = valueCountMap.get(nums2[i]);
            if (integer == null) integer = 0;
            integer++;
            valueCountMap.put(nums2[i], integer);
        }
    }

    public void add(int index, int val) {
        Integer integer = valueCountMap.get(nums2[index]);
        if (integer == null) integer = 1;
        integer--;
        valueCountMap.put(nums2[index],integer);

        Integer integer1 = valueCountMap.get(nums2[index] + val);
        if (integer1 == null) integer1 = 0;
        integer1++;
        valueCountMap.put(nums2[index] + val,integer1);
        nums2[index]+=val;
    }

    public int count(int tot) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i]>tot) break;
            Integer integers = valueCountMap.get(tot - nums1[i]);
            res += (integers == null ? 0 : integers);
        }
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */