package Problem_5724_绝对差值和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    int[] copy1;
    Map<Integer, Integer> map = new HashMap();
    int MaxCanReplaceIndex;
    int replaceValueAbs;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        copy1 = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(copy1);
        return 0;
    }
}