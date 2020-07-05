package Problem_0263_丑数;

class Solution {
    public boolean isUgly(int num) {
        if(num == 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1?true:false;
    }
}

class Test{
    public static void main(String[] args) {
        boolean ugly = new Solution().isUgly(14);
        System.out.println(ugly);
    }
}


