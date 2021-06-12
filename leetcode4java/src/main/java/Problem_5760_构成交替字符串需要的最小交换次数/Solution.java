package Problem_5760_构成交替字符串需要的最小交换次数;

class Solution {

    int singleZero = 0;
    int doubleZero = 0;
    int singleOne = 0;
    int doubleOne = 0;

    public int minSwaps(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean single = (i & 1) == 1;
            if (single) {
                if (s.charAt(i) == '0') singleZero++;
                else singleOne++;
            } else {
                if (s.charAt(i) == '0') doubleZero++;
                else doubleOne++;
            }
        }

        if (singleOne == doubleZero) {
            if (singleZero == doubleOne) {
                return Math.min(singleOne, singleZero);
            }
            return singleOne;
        } else {
            if (singleZero == doubleOne)
                return singleZero;
        }
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().minSwaps("01000");
        System.out.println(i);
    }
}