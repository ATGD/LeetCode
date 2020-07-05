package Problem_0119_杨辉三角2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastOne = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j < lastOne.size() - 1; j++) {
                lastOne.set(j, lastOne.get(j) + lastOne.get(j + 1));
            }
            lastOne.add(0, 1);
        }
        return lastOne;
    }

    public static void main(String[] args) {
        List<Integer> row = new Solution().getRow(4);

        System.out.println(row);
    }
}

