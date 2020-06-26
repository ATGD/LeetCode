package Problem_0118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> positionList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < positionList.size() - 1; j++)
                positionList.set(j, positionList.get(j) + positionList.get(j + 1));
            positionList.add(0, 1);
            resultList.add(new ArrayList<>(positionList));
        }
        return resultList;
    }
}

