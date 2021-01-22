package Problem_5475_统计好三元组;

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int m = arr[i];
                    int n = arr[j];
                    int o = arr[k];
                    if (Math.abs(m - n) <= a &&
                            Math.abs(n - o) <= b &&
                            Math.abs(o - m) <= c
                    ) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}