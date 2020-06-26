package Problem_0507_完美数;

class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 1) {
            return false;
        }
        int sum = 1; // 正整数一定会有一个1，同时不用考虑自身，所以单独处理
        int i = 2;
        double sqrt = Math.sqrt(num);
        for(;i < sqrt;i++) {
            if(num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        // 此处单独处理的原因在于只需要加1次i值，如果在循环中会加2次
        if(i * i == num) {
            sum += i;
        }
        return sum == num;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().checkPerfectNumber(28);
        System.out.println(b);
    }
}

