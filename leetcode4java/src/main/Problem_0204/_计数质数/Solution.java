package Problem_0204._计数质数;

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        boolean nums[] = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!nums[i])
                for (int j = 2 * i; j < n; j += i)
                    nums[j] = true;
        }
        int count = 0;
        for (int i = 2; i < n; i++)
            if (!nums[i])
                count++;
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().countPrimes(10);
        System.out.println(i);
    }
}

