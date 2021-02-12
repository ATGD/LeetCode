package Problem_0989_数组形式的整数加法;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> results = new ArrayList<>();
        int ALast = A.length;
        int Klast = K;
        int nextGra = 0;
        while (ALast > 0 || Klast > 0 || nextGra > 0) {
            int a;
            if (ALast > 0) {
                a = A[ALast - 1];
            } else {
                a = 0;
            }
            int b = Klast % 10;
            int c = nextGra % 10;
            int result = a + b + c;
            ALast--;
            Klast /= 10;
            c /= 10;
            results.add(0, result % 10);
            nextGra = result / 10;
        }
        return results;
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> integers = new Solution().addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1);
        System.out.println(integers);
    }
}