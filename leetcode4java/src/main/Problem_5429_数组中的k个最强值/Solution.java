package Problem_5429_数组中的k个最强值;

import java.util.Arrays;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int midIndex = (arr.length - 1) / 2;
        int start = 0;
        int end = arr.length - 1;
        int count = 0;
        int[] result = new int[k];
        while (count < k && start <= end) {
            int a = arr[start];
            int b = arr[end];
            int compare = Math.abs(a - arr[midIndex]) - Math.abs(b - arr[midIndex]);
            if (compare > 0) {
                result[count] = a;
                start++;
            } else {
                result[count] = b;
                end--;
            }
            count++;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] result = new Solution().getStrongest(new int[]{
                1, 1, 3, 5, 5,
        }, 2);
        System.out.println(result);
    }
}