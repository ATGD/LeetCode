package Problem_5383_给Nx3网格图涂色的方案数;

class Solution {

    int count = 0;

    public int numOfWays(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 12;
        long temp = 1000000007;
        long repeat = 6;
        long unrepeat = 6;
        for (int i = 2; i <= n; i++) {
            long newrep = (repeat * 3) % temp + unrepeat * 2 % temp;
            long newunrep = repeat * 2 % temp + unrepeat * 2 % temp;
            repeat = newrep;
            unrepeat = newunrep;
        }
        return (int) ((repeat + unrepeat) % temp);
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numOfWays(3);
        System.out.println(i);
    }
}