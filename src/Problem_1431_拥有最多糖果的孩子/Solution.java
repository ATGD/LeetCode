package Problem_1431_拥有最多糖果的孩子;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) max = Math.max(max, candy);
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) result.add((max - candy) <= extraCandies);
        return result;
    }
}

class Test{
    public static void main(String[] args) {
        List<Boolean> result = new Solution().kidsWithCandies(
                new int[]{
                        5,3,2,2,3
                },
                1
        );
        System.out.println(result);
    }
}