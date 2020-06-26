package Problem_0202_快乐数;

import java.util.LinkedList;
import java.util.List;

class Solution {

    /**
     * 1    1
     * 2    4
     * 3    9
     * 4    6
     * 5    5
     * 6    6
     * 7    9
     * 8    4
     * 9    1
     */
    /**
     * 1,2,3 = 14
     * 1,4 = 17
     * 1,7 = 50
     * 5,0 = 25
     * 2,5 = 29
     * 2,9 = 85
     * 8,5 = 89
     * 8,9 = 145
     * 1,4,5 = 42
     * 4,2 = 20
     * 2,0 = 4
     * 4 = 16
     * 1,6 = 37
     * 3,7 = 58
     * 5,8 = 89
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        List<Integer> resultSet = new LinkedList<>();
        while (!resultSet.contains(n) && n!=1) {
            resultSet.add(n);
            n = getSqSum(n);
        }
        return n == 1;
    }

    int getSqSum(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            sum += i * i;
            n = n / 10;
        }
        return sum;
    }
}

class Test {
    public static void main(String[] args) {
        boolean sqSum = new Solution().isHappy(323);
        System.out.println(sqSum);
    }
}

