package Problem_1018_可被5整除的二进制前缀;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int tmpNum = 0;
        for (int value : A) {
            tmpNum += (tmpNum << 1) + value;
            result.add(tmpNum % 5 == 0);
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        List<Boolean> result = new Solution().prefixesDivBy5(new int[]{
                0,1,1,1,1,1
        });
        System.out.println(result);
    }
}

