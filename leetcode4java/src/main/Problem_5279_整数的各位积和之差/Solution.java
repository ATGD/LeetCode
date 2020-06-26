package Problem_5279_整数的各位积和之差;

class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int muity = 1;
        while (n > 0) {
            int resume = n % 10;
            sum += resume;
            muity *= resume;
            n /= 10;
        }
        return muity - sum;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().subtractProductAndSum(123456);
        System.out.println(i);
    }
}

