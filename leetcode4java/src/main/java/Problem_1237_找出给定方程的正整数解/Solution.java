package Problem_1237_找出给定方程的正整数解;

import java.util.ArrayList;
import java.util.List;

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> resultList = new ArrayList<>();
        int startX = 1;
        while (customfunction.f(startX, 1) <= z) {
            int startY = 1;
            while (customfunction.f(startX, startY) <= z) {
                if (customfunction.f(startX, startY) == z) {
                    List<Integer> itemResult = new ArrayList<>();
                    itemResult.add(startX);
                    itemResult.add(startY);
                    resultList.add(itemResult);
                }
                startY++;
            }
            startX++;
        }
        return resultList;
    }
}

class CustomFunction {
    int f(int x, int y) {
        return x + y;
    }
}
