package Problem_5440_数组异或操作;

class Solution {
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }
}

class Test{
    public static void main(String[] args) {
        int i = new Solution().xorOperation(10, 5);
        System.out.println(i);
    }
}