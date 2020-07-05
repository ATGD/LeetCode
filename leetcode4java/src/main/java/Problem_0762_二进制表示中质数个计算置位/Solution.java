package Problem_0762_二进制表示中质数个计算置位;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countPrimeSetBits(int L, int R) {
        //0-20的质数列表，prime[i]为1，则i为质数
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        int res = 0;
        for (int i = L; i <= R; i++) {
            int t = Integer.bitCount(i);
            res += primes[t];
        }
        return res;
    }
}

