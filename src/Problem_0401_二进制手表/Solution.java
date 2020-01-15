package Problem_0401_二进制手表;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> resultList = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        resultList.clear();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    resultList.add(String.format("%02d:%02d", i, j));
                }
            }
        }
        return resultList;
    }


}

class Test {
    public static void main(String[] args) {
        List<String> strings = new Solution().readBinaryWatch(1);
        System.out.println(strings);
    }
}
