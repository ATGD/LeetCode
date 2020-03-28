package Problem_0441_排列硬币;

class Solution {
    public int arrangeCoins(int n) {
        int k = (int) Math.sqrt(2 * n);
        while (k * (k + 1) > 2 * n) k--;
        return k;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().arrangeCoins(0);
        System.out.println(i);
    }
}