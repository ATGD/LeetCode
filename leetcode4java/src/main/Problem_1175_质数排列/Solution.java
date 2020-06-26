package Problem_1175_质数排列;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numPrimeArrangements(int n) {
        int noPrimes = 0;
        List<Integer> primeList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                noPrimes++;
                continue;
            }
            boolean isPrime = true;
            for (int k = 0; k < primeList.size() && primeList.get(k) <= Math.sqrt(i); k++) {
                if (i % primeList.get(k) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primeList.add(i);
            else noPrimes++;
        }
        long result = 1;
        for (int i = 1; i <= noPrimes; i++) {
            result *= i;
            result %= 1000000007;
        }
        int size = primeList.size();
        for (int i = 1; i <= size; i++) {
            result *= i;
            result %= 1000000007;
        }
        return ((int) result);
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().numPrimeArrangements(5);
        System.out.println(result);
    }
}