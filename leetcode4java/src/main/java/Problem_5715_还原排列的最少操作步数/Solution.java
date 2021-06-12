package Problem_5715_还原排列的最少操作步数;


class Solution {
    public int reinitializePermutation(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 2;
            count++;
        }
        return count + 1;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().reinitializePermutation(6);
        System.out.println(i);
    }
}