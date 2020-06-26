package Problem_5368_找出数组中的幸运数;

class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[500];
        for (int value : arr) count[value - 1]++;
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == i + 1) return i + 1;
        }
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        int lucky = new Solution().findLucky(new int[]{1, 2, 2, 3, 3, 3});
        System.out.println(lucky);
    }
}
