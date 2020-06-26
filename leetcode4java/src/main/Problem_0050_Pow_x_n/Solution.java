package Problem_0050_Pow_x_n;

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        double currentPosValue = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1)
                result = result * currentPosValue;
            currentPosValue *= currentPosValue;
        }
        return result;
    }
}

class Test{
    public static void main(String[] args) {
        double v = new Solution().myPow(2.0000, 10);
        System.out.println(v);
    }
}
