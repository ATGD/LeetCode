package Problem_0476_数字的补数;

class Solution {
    public int findComplement(int num) {
//        int bitCount = 0;
//        int tmpNum = num;
//        while (tmpNum > 0) {
//            tmpNum = tmpNum >>> 1;
//            bitCount++;
//        }
//        return (1 << bitCount) - num - 1;
        int bitCount = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            tmpNum = tmpNum >>> 1;
            bitCount++;
        }
        return (((1 << bitCount))-1)^num;
    }
}

class Test {
    public static void main(String[] args) {
        int complement = new Solution().findComplement(5);
        System.out.println(complement);
    }
}