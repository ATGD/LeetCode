package Problem_0070_爬楼梯;

class Solution {
    public int climbStairs(int n) {
        int i = 1;
        int j = 1;
        int tmpN = 1;
        if (n == 0) return 0;
        while (tmpN < n) {
            int tmp = i + j;
            i = j;
            j = tmp;
            tmpN++;
        }
        return j;
    }
}

class Test{
    //1,1,2,3,5,8,13
    //0,1,2,3,4,5,6
    public static void main(String[] args) {
        int i = new Solution().climbStairs(6);
        System.out.println(i);
    }
}
