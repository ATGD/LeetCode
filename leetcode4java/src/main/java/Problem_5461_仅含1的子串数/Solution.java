package Problem_5461_仅含1的子串数;

import javafx.beans.binding.When;

import java.math.BigInteger;

class Solution {
    public int numSub(String s) {
        char[] chars = s.toCharArray();
        Integer start = null;
        BigInteger count = BigInteger.valueOf(0);
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == '0') {
                if (start != null) {
                    int tempLength = i - start;
                    BigInteger result = BigInteger.valueOf(1 + tempLength).multiply(BigInteger.valueOf(tempLength)).divide(BigInteger.valueOf(2));
                    count = count.add(result);
                    start = null;
                }
            } else if (start == null)
                start = i;
        }
        if (start != null) {
            int tempLength = length - start;
            BigInteger result = BigInteger.valueOf(1 + tempLength).multiply(BigInteger.valueOf(tempLength)).divide(BigInteger.valueOf(2));
            count = count.add(result);
        }
        return count.mod(new BigInteger("1000000007")).intValue();
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numSub("0110111");
        System.out.println(i);
    }
}