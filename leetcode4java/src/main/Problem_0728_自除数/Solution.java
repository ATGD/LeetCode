package Problem_0728_自除数;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < right - left + 1; i++) {
            boolean b = caluIsSelfDiv(i + left, (i + left));
            if (b) numList.add(i + left);
        }
        return numList;
    }

    public boolean caluIsSelfDiv(int num, int cNum) {
        if (cNum > 0) {
            return cNum % 10 != 0 && num % (cNum % 10) == 0 && caluIsSelfDiv(num, cNum / 10);
        } else return true;
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> integers = new Solution().selfDividingNumbers(1, 22);
        System.out.println(integers);
//        new Solution().caluIsSelfDiv(21, 21);
    }
}
