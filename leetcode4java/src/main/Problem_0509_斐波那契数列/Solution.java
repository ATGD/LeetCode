package Problem_0509_斐波那契数列;

class Solution {
    public int fib(int N) {
        int first = 0;
        int second = 1;
        if (N == 0)
            return first;
        if (N == 1)
            return second;
        int n = 1;
        while (n < N) {
            int temp = second;
            second += first;
            first = temp;
            n++;
        }
        return second;
    }

    public int fib1(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        else return fib1(N - 1) + fib1(N - 2);
    }
}

class Test {
    //0,1,1,2,3,5,8
    public static void main(String[] args) {
        int fib = new Solution().fib1(6);
        System.out.println(fib);
    }
}

