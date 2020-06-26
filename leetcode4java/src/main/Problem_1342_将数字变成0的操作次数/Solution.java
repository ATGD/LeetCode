package Problem_1342_将数字变成0的操作次数;

class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) num--;
            else num /= 2;
            count++;
            System.out.println(num);
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numberOfSteps(123);
        //122
        //61
        //60
        //30
        //15
        //14
        //7
        //6
        //3
        //2
        //1
        //0
        System.out.println(i);
    }
}