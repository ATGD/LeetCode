package Problem_0258_各位相加;

class Solution {
    public int addDigits(int num) {
        int tempNum = num;
        int sum = 0;
        while (tempNum > 0 || sum >= 10) {
            if (tempNum > 0) {
                sum += tempNum % 10;
                tempNum /= 10;
            } else {
                tempNum = sum;
                sum = 0;
            }
        }
        return sum;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().addDigits(978);
        System.out.println(i);
    }
}


