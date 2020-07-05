package Problem_0693_交替位二进制数;

class Solution {
    public boolean hasAlternatingBits(int n) {
        int tmp = n & 1;
        n = n >> 1;
        if (n == 0)
            return false;
        while (n > 0) {
            if (((n & 1) ^ tmp) == 0) {
                return false;
            }
            tmp = n & 1;
            n = n >> 1;
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().hasAlternatingBits(Integer.parseInt("11001011010", 2));
        System.out.println(b);
    }
}


