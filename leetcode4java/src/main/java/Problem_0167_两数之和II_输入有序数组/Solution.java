package Problem_0167_两数之和II_输入有序数组;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int value = numbers[low] + numbers[high] - target;
            if (value < 0) low++;
            else if (value == 0) return new int[]{low + 1, high + 1};
            else high--;
        }
        return new int[2];
    }
}

