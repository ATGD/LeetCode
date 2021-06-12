package Problem_5732_减小和重新排列数组后的最大元素;

import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int tmpValue = 1;
        for (int i = 1; i < arr.length; i++) {
            int oc = arr[i] - tmpValue;
            if (oc == 0) {
                continue;
            } else {
                tmpValue++;
            }
        }
        return tmpValue;
    }
}