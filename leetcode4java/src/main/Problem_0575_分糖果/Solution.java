package Problem_0575_分糖果;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> candyClass = new HashSet<>();
        for (int candy : candies) {
            candyClass.add(candy);
            if (candyClass.size() == candies.length / 2) {
                return candyClass.size();
            }
        }
        return candyClass.size();
    }
}