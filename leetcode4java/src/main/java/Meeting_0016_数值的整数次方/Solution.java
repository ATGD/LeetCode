package Meeting_0016_数值的整数次方;


class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = Math.abs(N);
        }
        double tempPositionValue = x;
        double result = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                result = result * tempPositionValue;
            }
            N /= 2;
            tempPositionValue *= tempPositionValue;
        }
        return result;
    }
}


class Test {
    public static void main(String[] args) {
        double isNumber = new Solution().myPow(2, 10);//2*2*2+ 4 +1
        System.out.println(isNumber);
    }
}