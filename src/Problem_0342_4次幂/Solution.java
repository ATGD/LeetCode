package Problem_0342_4次幂;

class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}

class Test {

    public static void main(String[] args) {
        boolean powerOfFour = new Solution().isPowerOfFour(16);
        System.out.println(powerOfFour);
    }
}

