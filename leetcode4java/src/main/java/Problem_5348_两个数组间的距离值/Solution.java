package Problem_5348_两个数组间的距离值;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        boolean[] arr = new boolean[2001];
        for (int value : arr2) arr[value - (-1000)] = true;
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int value = arr1[i];
            boolean isIn = false;
            for (int j = value - d; j <= value + d; j++) {
                if (j < -1000 || j > 1000) continue;
                if (arr[j - (-1000)]) {
                    isIn = true;
                    break;
                }
            }
            if (!isIn) count++;
        }
        return count;
    }
}