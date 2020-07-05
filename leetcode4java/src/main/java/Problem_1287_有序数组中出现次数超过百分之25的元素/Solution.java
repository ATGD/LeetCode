package Problem_1287_有序数组中出现次数超过百分之25的元素;

class Solution {
    public int findSpecialInteger(int[] arr) {
        int value = arr[0];
        int count = 0;
        for (int i : arr) {
            if (i == value) {
                count++;
                if (count > arr.length / 4f)
                    return value;
            } else {
                value = i;
                count = 1;
            }
        }
        return value;
    }
}

