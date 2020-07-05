package Problem_5405_形成两个异或相等数组的三元组数目;

class Solution {
    public int countTriplets(int[] arr) {
        int i, j, k;
        int count = 0;
        if (arr.length <= 1) return 0;
        for (i = 0; i <= arr.length - 2; i++) {
            for (j = i + 1; j < arr.length; j++) {
                for (k = j; k < arr.length; k++) {
                    int a = 0;
                    int b = 0;
                    for (int m = i; m < j; m++) {
                        a ^= arr[m];
                    }
                    for (int n = j; n <= k; n++) {
                        b ^= arr[n];
                    }
                    if (a == b) count++;
                }
            }
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().countTriplets(new int[]{
                1, 1, 1, 1, 1
        });
        System.out.println(result);
    }
}