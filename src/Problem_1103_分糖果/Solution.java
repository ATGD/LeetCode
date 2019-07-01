package Problem_1103_分糖果;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] candyDistArray = new int[num_people];
        int disIndex = 0;
        int shoudGive = 1;
        while (candies != 0) {
            if (candies < shoudGive) {
                candyDistArray[disIndex] += candies;
                return candyDistArray;
            } else {
                candyDistArray[disIndex] += shoudGive;
                candies -= shoudGive;
            }
            shoudGive++;
            disIndex = (disIndex + 1) % num_people;
        }
        return candyDistArray;
    }
}

class Text {
    public static void main(String[] args) {
        int[] ints = new Solution().distributeCandies(10, 3);
        System.out.println(ints);
    }
}

